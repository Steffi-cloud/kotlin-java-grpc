/*
 * package com.example.audit;
 * 
 * import io.grpc.ManagedChannel; import io.grpc.ManagedChannelBuilder;
 * 
 * public class AuditClient {
 * 
 * public static void main(String[] args) { // Build a channel to the gRPC
 * server ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",
 * 9090) .usePlaintext() // disable TLS for localhost .build();
 * 
 * // Create a stub (blocking client) AuditServiceGrpc.AuditServiceBlockingStub
 * stub = AuditServiceGrpc.newBlockingStub(channel);
 * 
 * // Build a request AuditRequest request = AuditRequest.newBuilder()
 * .setUserId("user123") .setAction("CREATE") .setResource("invoice")
 * .setTimestamp("2025-10-03T20:30:00Z") .setDetails("Created invoice ID 456")
 * .build();
 * 
 * // Call the service AuditResponse response = stub.logAuditEvent(request);
 * 
 * // Print the response System.out.println("Success: " +
 * response.getSuccess()); System.out.println("Message: " +
 * response.getMessage());
 * 
 * // Shutdown the channel channel.shutdown(); } }
 */