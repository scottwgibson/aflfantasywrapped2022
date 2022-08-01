package com.scottwgibson.aflfantasywrapped.templates

import com.scottwgibson.aflfantasywrapped.aflfantasy.models.PlayerId
import io.ktor.server.html.Template
import io.ktor.server.html.insert
import kotlinx.html.ButtonType
import kotlinx.html.HTML
import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.h1
import kotlinx.html.id
import kotlinx.html.span

class TestWrappedTemplate(
    val teamId: String,
    val playerIds: Iterable<PlayerId>
) : Template<HTML> {
    override fun HTML.apply() {
        insert(MainTemplate()) {
            body {
                div {
                    h1 { +"Team Name: $teamId" }
                }
                div(classes = "carousel carousel-dark slide") {
                    id = "carouselExampleControls"
                    attributes["data-bs-ride"] = "carouselExampleControls"
                    attributes["data-bs-interval"] = "false"
                    attributes["data-bs-wrap"] = "false"

                    div(classes = "carousel-indicators") {
                        playerIds.forEachIndexed { i, it ->
                            button(classes = "active") {
                                type = ButtonType.button
                                attributes["data-bs-target"] = "#carouselExampleControls"
                                attributes["data-bs-slide-to"] = "$i"
                                attributes["aria-label"] = "Slide $i"
                                attributes["aria-current"] = "true"
                                if (i == 0) attributes["aria-current"] = "true"
                            }
                        }
                    }
                    div(classes = "carousel-inner") {
                        playerIds.forEachIndexed { i, it ->
                            insert(PlayerCarouselItem(it, i == 0)) {}
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
