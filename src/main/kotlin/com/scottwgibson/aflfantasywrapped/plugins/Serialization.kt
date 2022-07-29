package com.scottwgibson.aflfantasywrapped.plugins

import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.netty.handler.codec.compression.StandardCompressionOptions.gzip
import kotlinx.serialization.json.Json

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        gzip()
        Json {
            ignoreUnknownKeys = true
        }
    }
}
