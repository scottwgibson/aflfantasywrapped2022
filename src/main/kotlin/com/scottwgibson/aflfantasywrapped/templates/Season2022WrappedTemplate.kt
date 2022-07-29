package com.scottwgibson.aflfantasywrapped.templates

import io.ktor.server.html.Template
import io.ktor.server.html.insert
import kotlinx.html.ButtonType
import kotlinx.html.HTML
import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.h1
import kotlinx.html.id
import kotlinx.html.span

class Season2022WrappedTemplate(
    val teamId: Int
) : Template<HTML> {
    override fun HTML.apply() {
        insert(MainTemplate()) {
            body {
                div {
                    h1 { +"TeamID: $teamId" }
                }
                div(classes = "carousel slide") {
                    id = "carouselExampleControls"
                    attributes["data-bs-ride"] = "carousel"
                    div(classes = "carousel-inner") {
                        div(classes = "carousel-item active") {
                            // h1 { +"Test1" }
                            // img(classes = "d-block w-100", src = "https://placeimg.com/1080/500/animals")
                        }
                        div(classes = "carousel-item") {
                            // h1 { +"Test2" }
                            // img(classes = "d-block w-100", src = "https://placeimg.com/1080/500/arch")
                        }
                    }
                    button(classes = "carousel-control-prev") {
                        type = ButtonType.button
                        attributes["data-bs-target"] = "#carouselExampleControls"
                        attributes["data-bs-slide"] = "prev"
                        span("carousel-control-prev-icon") {
                            attributes["aria-hidden"] = "true"
                        }
                        span("visually-hidden") { +"Previous" }
                    }
                    button(classes = "carousel-control-next") {
                        type = ButtonType.button
                        attributes["data-bs-target"] = "#carouselExampleControls"
                        attributes["data-bs-slide"] = "next"
                        span("carousel-control-next-icon") {
                            attributes["aria-hidden"] = "true"
                        }
                        span("visually-hidden") { +"Next" }
                    }
                }
            }
        }
    }
}
