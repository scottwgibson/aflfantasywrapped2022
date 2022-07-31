package com.scottwgibson.aflfantasywrapped

import com.scottwgibson.aflfantasywrapped.aflfantasy.clients.AflFantasyClient
import com.scottwgibson.aflfantasywrapped.plugins.configureSerialization
import com.scottwgibson.aflfantasywrapped.templates.home.Home2022Page
import io.ktor.client.HttpClient
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.html.respondHtmlTemplate
import io.ktor.server.response.respondRedirect
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import kotlinx.serialization.ExperimentalSerializationApi

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@OptIn(ExperimentalSerializationApi::class)
fun Application.module(
    httpClient: HttpClient = defaultHttpClient
) {
    configureSerialization()

    val server = Server(AflFantasyClient(httpClient))

    routing {
        get("/2022") {
            val teamId = call.parameters["teamId"]?.toInt()

            if (teamId != null) {
                call.respondRedirect("/2022/$teamId")
            } else {
                call.respondHtmlTemplate(Home2022Page()) {}
            }
        }

        get("/2022/{teamId}") {
            val teamId = call.parameters["teamId"]?.toInt()!!
            server.showWrapupForUser(call, teamId)
        }
    }
}
