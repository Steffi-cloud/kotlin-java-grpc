package com.example.server

import com.example.GreeterGrpcKt // ✅ This is correct now
import com.example.GreeterProto // ✅ This contains HelloRequest and HelloReply
import io.grpc.Server
import io.grpc.ServerBuilder
import com.example.service.GreeterService

/*
 * class GreeterService : GreeterGrpcKt.GreeterCoroutineImplBase() { override
 * suspend fun sayHello(request: GreeterProto.HelloRequest):
 * GreeterProto.HelloReply { return GreeterProto.HelloReply.newBuilder()
 * .setMessage("Hello, ${request.name}") .build() } }
 */
fun main() {
    val server: Server = ServerBuilder
        .forPort(50051)
        .addService(GreeterService())
        .build()

    server.start()
    println("Server started on port 50051")
    server.awaitTermination()
}
