package com.kishorek.service;

import com.kishorek.hello.GreeterGrpc;
import com.kishorek.hello.HelloReply;
import com.kishorek.hello.HelloRequest;
import io.grpc.stub.StreamObserver;

public class GreeterGrpcImpl extends GreeterGrpc.GreeterImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder().setMessage("Hello "+request.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
