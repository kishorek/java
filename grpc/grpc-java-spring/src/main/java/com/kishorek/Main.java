package com.kishorek;

import com.kishorek.server.GRPCServer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
@ComponentScan(basePackages = "com.kishorek")
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        GRPCServer server = context.getBean("GRPCServer",GRPCServer.class);
        server.start();
        server.awaitTermination();
    }
}