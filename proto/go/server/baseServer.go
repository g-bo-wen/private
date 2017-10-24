package main

import ("flag"
	pb "../proto"
	"context"
	"log"
	"net"
	"fmt"
	"google.golang.org/grpc/credentials"
	"google.golang.org/grpc"
	"io"
	"os"
)

var (
	tls        = flag.Bool("tls", true, "Connection uses TLS if true, else plain TCP")
	certFile   = flag.String("cert_file", "", "The TLS cert file")
	keyFile    = flag.String("key_file", "", "The TLS key file")
	jsonDBFile = flag.String("json_db_file", "testdata/route_guide_db.json", "A json file containing a list of features")
	port       = flag.Int("port", 10000, "The server port")
)

type testServer struct {

}

func (s *testServer) NoStream (ctx context.Context, request *pb.Request) (response *pb.Response, error error) {
	log.Printf("noStream request is %s \n", request.Msg)
	return &pb.Response{"i get it"}, nil
}

func (s *testServer) RequestStream (stream pb.Proto_RequestStreamServer) error {
	log.Println("RequestStream start")
	var sl []string
	for {
		request, err := stream.Recv()
		if err != nil {  // 当客户端传输完数据后, 会返回一个 EOF 的错误
			break
		}
		if err == io.EOF {
			break
		}
		log.Printf("requestStream receive request %s \n", request.Msg)
		sl = append(sl, request.Msg)
	}
	err := stream.SendAndClose(&pb.Response{"i get it"})
	fmt.Println(err)
	return err
}

func (s *testServer) ResponseStream (request *pb.Request, stream pb.Proto_ResponseStreamServer) error {
	log.Printf("responseStream reveive request %s \n", request.Msg)
	for a := 0; a < 5; a ++ {
		stream.Send(&pb.Response{"okkkkkk"})
	}
	return nil
}

func (s *testServer) AllStream (stream pb.Proto_AllStreamServer) error {
	for {
		request, err := stream.Recv()
		if err != nil {
			return nil
		}
		log.Printf("allStream receive request %s \n", request.Msg)
		stream.Send(&pb.Response{request.Msg + "ok"})
	}
}

func main() {
	fmt.Println("server start")
	flag.Parse()
	lis, err := net.Listen("tcp", fmt.Sprintf("localhost:%d", *port))
	if err != nil {
		log.Printf("server start fail: %v \n", err)
	}
	var opts []grpc.ServerOption
	if *tls {
		log.Println("use TLS")
		path, _ := os.Getwd()
		if *certFile == "" {
			*certFile = path + "/certificate/ca.pem"
		}
		if *keyFile == "" {
			*keyFile = path + "/certificate/server_pri.key"
		}
		creds, err := credentials.NewServerTLSFromFile(*certFile, *keyFile)
		if err != nil {
			log.Printf("Failed to generate credentials %v \n", err)
		}
		opts = []grpc.ServerOption{grpc.Creds(creds)}
	}
	grpcServer := grpc.NewServer(opts...)
	pb.RegisterProtoServer(grpcServer, &testServer{})
	grpcServer.Serve(lis)
	log.Println("server is start")
}