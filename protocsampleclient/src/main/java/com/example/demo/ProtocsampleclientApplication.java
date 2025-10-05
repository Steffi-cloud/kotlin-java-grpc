package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.audit.AuditRequest;
import com.example.audit.AuditResponse;
import com.example.audit.AuditServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@SpringBootApplication
public class ProtocsampleclientApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ProtocsampleclientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		 ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
	                .usePlaintext() // disable TLS for localhost
	                .build();

	        // Create a stub (blocking client)
	        AuditServiceGrpc.AuditServiceBlockingStub stub = AuditServiceGrpc.newBlockingStub(channel);

	        // Build a request
	        AuditRequest request = AuditRequest.newBuilder()
	                .setUserId("user123")
	                .setAction("CREATE")
	                .setResource("invoice")
	                .setTimestamp("2025-10-03T20:30:00Z")
	                .setDetails("Created invoice ID 456")
	                .build();

	        // Call the service
	        AuditResponse response = stub.logAuditEvent(request);

	        // Print the response
	        System.out.println("Success: " + response.getSuccess());
	        System.out.println("Message: " + response.getMessage());

	        // Shutdown the channel
	        channel.shutdown();
	}

}
