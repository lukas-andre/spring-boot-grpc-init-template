package grpc.example.grpc;

import grpc.example.HelloGrpc.HelloRequest;
import grpc.example.HelloGrpc.HelloResponse;
import grpc.example.HelloGrpcServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class ExampleGrpc extends HelloGrpcServiceGrpc.HelloGrpcServiceImplBase {

    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        String responseMessage = "World";
        responseObserver.onNext(HelloResponse.newBuilder().setResponseMessage(responseMessage).setStatus("OK").build());
        responseObserver.onCompleted();
    }
}
