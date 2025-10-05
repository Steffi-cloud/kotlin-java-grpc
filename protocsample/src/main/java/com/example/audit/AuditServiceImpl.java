package com.example.audit;

import io.grpc.stub.StreamObserver;

public class AuditServiceImpl extends AuditServiceGrpc.AuditServiceImplBase {

    @Override
    public void logAuditEvent(AuditRequest request, StreamObserver<AuditResponse> responseObserver) {
        // Logging logic (you can integrate with a DB, file, etc.)
        System.out.println("Received audit log:");
        System.out.println("User ID: " + request.getUserId());
        System.out.println("Action: " + request.getAction());
        System.out.println("Resource: " + request.getResource());
        System.out.println("Timestamp: " + request.getTimestamp());
        System.out.println("Details: " + request.getDetails());

        // Create response
        AuditResponse response = AuditResponse.newBuilder()
                .setSuccess(true)
                .setMessage("Audit logged successfully")
                .build();

        // Send response
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
