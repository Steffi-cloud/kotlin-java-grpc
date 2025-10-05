package com.example.service

import com.example.GreeterGrpcKt // ✅ This is correct now
import com.example.GreeterProto // ✅ This contains HelloRequest and HelloReply
import io.grpc.Server
import io.grpc.ServerBuilder


class GreeterService : GreeterGrpcKt.GreeterCoroutineImplBase() {
    override
    suspend fun sayHello(request: GreeterProto.HelloRequest):
            GreeterProto.HelloReply {
        return GreeterProto.HelloReply.newBuilder()
            .setMessage("Hello, ${request.name}").build()
    }
}
 