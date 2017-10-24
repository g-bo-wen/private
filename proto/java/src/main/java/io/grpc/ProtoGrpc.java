package io.grpc;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.7.0)",
    comments = "Source: proto.proto")
public final class ProtoGrpc {

  private ProtoGrpc() {}

  public static final String SERVICE_NAME = "grpc.Proto";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.grpc.Request,
      io.grpc.Response> METHOD_NO_STREAM =
      io.grpc.MethodDescriptor.<io.grpc.Request, io.grpc.Response>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "grpc.Proto", "noStream"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              io.grpc.Request.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              io.grpc.Response.getDefaultInstance()))
          .setSchemaDescriptor(new ProtoMethodDescriptorSupplier("noStream"))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.grpc.Request,
      io.grpc.Response> METHOD_REQUEST_STREAM =
      io.grpc.MethodDescriptor.<io.grpc.Request, io.grpc.Response>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "grpc.Proto", "requestStream"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              io.grpc.Request.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              io.grpc.Response.getDefaultInstance()))
          .setSchemaDescriptor(new ProtoMethodDescriptorSupplier("requestStream"))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.grpc.Request,
      io.grpc.Response> METHOD_RESPONSE_STREAM =
      io.grpc.MethodDescriptor.<io.grpc.Request, io.grpc.Response>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "grpc.Proto", "responseStream"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              io.grpc.Request.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              io.grpc.Response.getDefaultInstance()))
          .setSchemaDescriptor(new ProtoMethodDescriptorSupplier("responseStream"))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.grpc.Request,
      io.grpc.Response> METHOD_ALL_STREAM =
      io.grpc.MethodDescriptor.<io.grpc.Request, io.grpc.Response>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "grpc.Proto", "allStream"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              io.grpc.Request.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              io.grpc.Response.getDefaultInstance()))
          .setSchemaDescriptor(new ProtoMethodDescriptorSupplier("allStream"))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProtoStub newStub(io.grpc.Channel channel) {
    return new ProtoStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProtoBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ProtoBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProtoFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ProtoFutureStub(channel);
  }

  /**
   */
  public static abstract class ProtoImplBase implements io.grpc.BindableService {

    /**
     */
    public void noStream(io.grpc.Request request,
        io.grpc.stub.StreamObserver<io.grpc.Response> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_NO_STREAM, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<io.grpc.Request> requestStream(
        io.grpc.stub.StreamObserver<io.grpc.Response> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_REQUEST_STREAM, responseObserver);
    }

    /**
     */
    public void responseStream(io.grpc.Request request,
        io.grpc.stub.StreamObserver<io.grpc.Response> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_RESPONSE_STREAM, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<io.grpc.Request> allStream(
        io.grpc.stub.StreamObserver<io.grpc.Response> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_ALL_STREAM, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_NO_STREAM,
            asyncUnaryCall(
              new MethodHandlers<
                io.grpc.Request,
                io.grpc.Response>(
                  this, METHODID_NO_STREAM)))
          .addMethod(
            METHOD_REQUEST_STREAM,
            asyncClientStreamingCall(
              new MethodHandlers<
                io.grpc.Request,
                io.grpc.Response>(
                  this, METHODID_REQUEST_STREAM)))
          .addMethod(
            METHOD_RESPONSE_STREAM,
            asyncServerStreamingCall(
              new MethodHandlers<
                io.grpc.Request,
                io.grpc.Response>(
                  this, METHODID_RESPONSE_STREAM)))
          .addMethod(
            METHOD_ALL_STREAM,
            asyncBidiStreamingCall(
              new MethodHandlers<
                io.grpc.Request,
                io.grpc.Response>(
                  this, METHODID_ALL_STREAM)))
          .build();
    }
  }

  /**
   */
  public static final class ProtoStub extends io.grpc.stub.AbstractStub<ProtoStub> {
    private ProtoStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProtoStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProtoStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProtoStub(channel, callOptions);
    }

    /**
     */
    public void noStream(io.grpc.Request request,
        io.grpc.stub.StreamObserver<io.grpc.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_NO_STREAM, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<io.grpc.Request> requestStream(
        io.grpc.stub.StreamObserver<io.grpc.Response> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(METHOD_REQUEST_STREAM, getCallOptions()), responseObserver);
    }

    /**
     */
    public void responseStream(io.grpc.Request request,
        io.grpc.stub.StreamObserver<io.grpc.Response> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_RESPONSE_STREAM, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<io.grpc.Request> allStream(
        io.grpc.stub.StreamObserver<io.grpc.Response> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_ALL_STREAM, getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class ProtoBlockingStub extends io.grpc.stub.AbstractStub<ProtoBlockingStub> {
    private ProtoBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProtoBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProtoBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProtoBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.Response noStream(io.grpc.Request request) {
      return blockingUnaryCall(
          getChannel(), METHOD_NO_STREAM, getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<io.grpc.Response> responseStream(
        io.grpc.Request request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_RESPONSE_STREAM, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ProtoFutureStub extends io.grpc.stub.AbstractStub<ProtoFutureStub> {
    private ProtoFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProtoFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProtoFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProtoFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.Response> noStream(
        io.grpc.Request request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_NO_STREAM, getCallOptions()), request);
    }
  }

  private static final int METHODID_NO_STREAM = 0;
  private static final int METHODID_RESPONSE_STREAM = 1;
  private static final int METHODID_REQUEST_STREAM = 2;
  private static final int METHODID_ALL_STREAM = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ProtoImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ProtoImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_NO_STREAM:
          serviceImpl.noStream((io.grpc.Request) request,
              (io.grpc.stub.StreamObserver<io.grpc.Response>) responseObserver);
          break;
        case METHODID_RESPONSE_STREAM:
          serviceImpl.responseStream((io.grpc.Request) request,
              (io.grpc.stub.StreamObserver<io.grpc.Response>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REQUEST_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.requestStream(
              (io.grpc.stub.StreamObserver<io.grpc.Response>) responseObserver);
        case METHODID_ALL_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.allStream(
              (io.grpc.stub.StreamObserver<io.grpc.Response>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ProtoBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProtoBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.grpc.MyProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Proto");
    }
  }

  private static final class ProtoFileDescriptorSupplier
      extends ProtoBaseDescriptorSupplier {
    ProtoFileDescriptorSupplier() {}
  }

  private static final class ProtoMethodDescriptorSupplier
      extends ProtoBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ProtoMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ProtoGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProtoFileDescriptorSupplier())
              .addMethod(METHOD_NO_STREAM)
              .addMethod(METHOD_REQUEST_STREAM)
              .addMethod(METHOD_RESPONSE_STREAM)
              .addMethod(METHOD_ALL_STREAM)
              .build();
        }
      }
    }
    return result;
  }
}
