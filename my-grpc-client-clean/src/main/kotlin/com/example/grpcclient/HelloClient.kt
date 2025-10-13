package com.example.grpcclient

import com.example.grpcservice.HelloRequest
import com.example.grpcservice.HelloServiceGrpcKt
import io.grpc.ManagedChannelBuilder
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    runBlocking {
        val channel = io.grpc.ManagedChannelBuilder.forAddress("localhost", 9090)
            .usePlaintext()
            .build()

        val stub = com.example.grpcservice.HelloServiceGrpcKt.HelloServiceCoroutineStub(channel)

        val request = com.example.grpcservice.HelloRequest.newBuilder()
            .setName("Kotlin Client")
            .build()

        val response = stub.sayHello(request)
        println("Response from server: ${response.message}")

        channel.shutdown()
    }
}
