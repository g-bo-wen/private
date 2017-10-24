package client;

import io.grpc.*;
import io.grpc.stub.StreamObserver;

import java.security.KeyStoreException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestClient {
    private static final Logger log = Logger.getLogger(TestClient.class.getName());

    private ManagedChannel channel;
    private ProtoGrpc.ProtoBlockingStub blockingStub;
    private ProtoGrpc.ProtoStub newStub;

    public TestClient(String host, int port) throws KeyStoreException {
        channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext(true).build();
        blockingStub = ProtoGrpc.newBlockingStub(this.channel);
        newStub = ProtoGrpc.newStub(this.channel);
    }


    public void shutdown() {
        log("shutdown");
        channel.shutdownNow();
    }

    private void log(String msg) {
        log.log(Level.INFO, msg + "\t" + System.currentTimeMillis());
    }

    public void noStream() {
        log("no stream start");
        Request request = Request.newBuilder().setMsg("no stram").build();
        Response response = blockingStub.noStream(request);
        log("no stream receive response " + response.getMsg());
    }

    public void requestSream() {
        log("request stream start");
        StreamObserver<Response> responseStreamObserver = new StreamObserver<Response>() {
            public void onNext(Response value) {
                log("requestSream responseStreamObserver onNext receive response " + value.getMsg() );
            }

            public void onError(Throwable t) {
                log("requestSream responseStreamObserver occur a error " + t.getMessage());
            }

            public void onCompleted() {
                log("requestSream responseStreamObserver completed");
            }
        };
        StreamObserver<Request> requestStreamObserver = newStub.requestStream(responseStreamObserver);
        try {
            for (int i = 0; i < 5; i++) {
                log("requestSream requestStreamObserver send request " + i + "cxx");
                requestStreamObserver.onNext(Request.newBuilder().setMsg(i + "cxx").build());
            }
        } catch (Exception e) {
            log("requestSream occur a error: " + e.getMessage());
        }
        requestStreamObserver.onCompleted(); // 表示数据已经发送完毕. 这时候要等待服务器返回数据, 不能结束方法
        try {
            Thread.sleep(2000);  // 所以要暂停一下
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void responseStream() {
        log("responseStream start");
        Request request = Request.newBuilder().setMsg("responseStream").build();
        try {
            Iterator<Response> responseStream = blockingStub.responseStream(request);
            while (responseStream.hasNext()) {
                Response response = responseStream.next();
                log("responseStream receive response " + response.getMsg());
            }
        } catch (Exception e) {
            log("responseStream occur a error " + e.getMessage());
        }
    }

    public void allStream() {
        log("allStream start");
        final StreamObserver<Request> requestStreamObserver = newStub.allStream(new StreamObserver<Response>() {
            public void onNext(Response value) {
                log("allStream requestStreamObserver receive response " + value.getMsg());
            }

            public void onError(Throwable t) {
                log("allStream requestStreamObserver occur a error");
            }

            public void onCompleted() {
                log("allStream requestStreamObserver completed");
            }
        });
        Request[] requests = {
                Request.newBuilder().setMsg("1").build(),
                Request.newBuilder().setMsg("1").build()
        };
        for (Request request : requests) {
            log("allStream send request " + request.getMsg());
            requestStreamObserver.onNext(request);
        }
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        requestStreamObserver.onCompleted();
    }

    public static void main(String[] args) throws Exception {
        TestClient client = new TestClient("localhost", 10000);
        client.allStream();
        client.shutdown();
    }
}
