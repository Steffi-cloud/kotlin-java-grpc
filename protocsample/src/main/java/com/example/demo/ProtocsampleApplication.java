package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.audit.AuditServiceImpl;

import io.grpc.Server;
import io.grpc.ServerBuilder;

@SpringBootApplication
public class ProtocsampleApplication implements CommandLineRunner
{

	public static void main(String[] args) {
		SpringApplication.run(ProtocsampleApplication.class, args);
	}

	@Override 
	public void run(String... args) throws Exception { // TODO
	//  Auto-generated method stub 
	  int port = 9090;
	  
	  Server server = ServerBuilder.forPort(port) .addService(new
	  AuditServiceImpl()) .build();
	  
	  System.out.println("Starting gRPC server on port " + port + "...");
	  server.start(); System.out.println("Server started.");
	  
	  server.awaitTermination(); }

}
