package com.scottwgibson.aflfantasywrapped

import com.scottwgibson.aflfantasywrapped.aflfantasy.clients.AflFantasyClient
import com.scottwgibson.aflfantasywrapped.aflfantasy.clients.aflFantasyClientConfig
import com.scottwgibson.aflfantasywrapped.plugins.configureSerialization
import com.scottwgibson.aflfantasywrapped.templates.home.Home2022Page
import io.ktor.client.HttpClient
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.html.respondHtmlTemplate
import io.ktor.server.http.content.resources
import io.ktor.server.http.content.static
import io.ktor.server.http.content.staticBasePackage
import io.ktor.server.response.respondRedirect
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module(
    httpClient: HttpClient = defaultHttpClient
) {
    configureSerialization()

    val aflFantasyClientConfig = environment.config.aflFantasyClientConfig()
    val server = Server(AflFantasyClient(httpClient, aflFantasyClientConfig))

    routing {
        get {
            call.respondHtmlTemplate(Home2022Page()) {}
        }

        get("/team") {
            val teamId = call.parameters["teamId"]?.toInt()
            if (teamId != null) {
                call.respondRedirect("/team/$teamId")
            }
        }

        get("/team/{teamId}") {
            val teamId = call.parameters["teamId"]?.toInt()!!
            server.showWrapupForUser(call, teamId)
        }

        static("/static") {
            staticBasePackage = "static"
            resources(".")
        }
    }
}
