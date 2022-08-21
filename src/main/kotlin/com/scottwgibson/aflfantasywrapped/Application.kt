package com.scottwgibson.aflfantasywrapped

import com.scottwgibson.aflfantasywrapped.aflfantasy.clients.AflFantasyClient
import com.scottwgibson.aflfantasywrapped.aflfantasy.clients.aflFantasyClientConfig
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.insights.CalvinsCaptainsData
import com.scottwgibson.aflfantasywrapped.plugins.configureSerialization
import com.scottwgibson.aflfantasywrapped.templates.about.AboutPage
import com.scottwgibson.aflfantasywrapped.templates.error.ErrorPage
import com.scottwgibson.aflfantasywrapped.templates.home.HomePage
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
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import org.slf4j.LoggerFactory

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module(
    httpClient: HttpClient = defaultHttpClient
) {
    configureSerialization()
    val logger = LoggerFactory.getLogger("application")

    val aflFantasyClientConfig = environment.config.aflFantasyClientConfig()
    val shareUrl = environment.config.property("social.url").getString()
    val calvinsCaptains: CalvinsCaptainsData =
        this::class.java.classLoader.getResource("data/CalvinsCaptains.json")
            ?.openStream()
            ?.let { Json.decodeFromStream(it) }
            ?: throw Exception("Unable to load calvin's captain data")

    val server = Server(AflFantasyClient(httpClient, aflFantasyClientConfig), calvinsCaptains, shareUrl)

    routing {
        get {
            call.respondHtmlTemplate(HomePage()) {}
        }

        get("/search") {
            val userIdParam = call.parameters["userId"]
            val sharelinkParam = call.parameters["sharelink"]
            try {
                val userId = if (userIdParam?.isNotEmpty() == true) {
                    userIdParam.toInt()
                } else if (sharelinkParam?.isNotEmpty() == true) {
                    server.extractUserIdFromShareLink(sharelinkParam)
                } else null

                if (userId != null) {
                    call.respondRedirect("/user/$userId")
                }
            } catch (ex: Exception) {
                logger.error(
                    "search",
                    mapOf(
                        "userIdParam" to userIdParam,
                        "sharelinkParam" to sharelinkParam
                    ),
                    ex
                )
                call.respondRedirect("/error")
            }
        }

        get("/user/{userId}") {
            val userId = call.parameters["userId"]
            try {
                val id = userId?.toInt()!!
                server.showWrapupForUser(call, id)
            } catch (ex: Exception) {
                logger.error("user", mapOf("userIdParam" to userId), ex)
                call.respondRedirect("/error")
            }
        }

        get("/error") {
            call.respondHtmlTemplate(ErrorPage()) {}
        }

        get("/about") {
            call.respondHtmlTemplate(AboutPage()) {}
        }

        static("/static") {
            staticBasePackage = "static"
            resources(".")
        }
    }
}
