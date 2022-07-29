package com.scottwgibson.aflfantasywrapped.plugins

import com.scottwgibson.aflfantasywrapped.templates.Home2022
import com.scottwgibson.aflfantasywrapped.templates.Season2022WrappedTemplate
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.html.respondHtmlTemplate
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

fun Application.configureRouting() {
    routing {
        get("/2022") {
            call.respondHtmlTemplate(Home2022()) {}
        }
        get("/2022/{teamId}") {
            val teamId = call.parameters["teamId"]?.toInt()
            call.respondHtmlTemplate(Season2022WrappedTemplate(teamId!!)) {}
        }
    }
}
