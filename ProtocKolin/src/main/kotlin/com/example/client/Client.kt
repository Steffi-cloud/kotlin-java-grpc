package com.example.client

import io.grpc.ManagedChannelBuilder
import kotlinx.coroutines.runBlocking
import com.example.GreeterGrpcKt
import com.example.GreeterProto.HelloRequest

fun main() = runBlocking {
    // Build the channel to the server at localhost:50051
    val channel = ManagedChannelBuilder.forAddress("localhost", 50051)
        .usePlaintext() // Disable TLS for simplicity (only for dev/testing)
        .build()

    try {
        // Create a coroutine stub
        val stub = GreeterGrpcKt.GreeterCoroutineStub(channel)

        // Build the request message
        val request = HelloRequest.newBuilder()
            .setName("Kotlin User")
            .build()

        // Call the sayHello RPC and suspend until response
        val response = stub.sayHello(request)

        // Print the server response
        println("Server response: ${response.message}")
    } catch (e: Exception) {
        println("RPC failed: ${e.message}")
    } finally {
        // Shutdown the channel gracefully
        channel.shutdown()
        // Optionally, wait for termination (with timeout)
        // channel.awaitTermination(5, TimeUnit.SECONDS)
    }
}
