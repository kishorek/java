package com.kishorek.server;

import com.kishorek.Main;
import com.kishorek.services.BaseGrpcService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


@Component
public class GRPCServer {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    private Server server;

    @Autowired
    private List<BaseGrpcService> services;

    public void start() throws IOException {
        /* The port on which the server should run */
        int port = 50051;

        ServerBuilder builder = ServerBuilder.forPort(port);
        for(BaseGrpcService service: this.services){
            builder.addService(service);
        }

        server = builder.addService(ProtoReflectionService.newInstance())
                .build()
                .start();
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                this.stop();
                System.err.println("*** server shut down");
            }
        });
    }

    public void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    public void awaitTermination() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }
}
