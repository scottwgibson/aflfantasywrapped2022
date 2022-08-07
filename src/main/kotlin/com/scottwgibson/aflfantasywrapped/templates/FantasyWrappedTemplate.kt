package com.scottwgibson.aflfantasywrapped.templates

import com.scottwgibson.aflfantasywrapped.services.WrappedData
import com.scottwgibson.aflfantasywrapped.templates.wrapped.MostPopularCaptainCarouselItem
import com.scottwgibson.aflfantasywrapped.templates.wrapped.WelcomeCarouselItem
import io.ktor.server.html.Template
import io.ktor.server.html.insert
import kotlinx.html.ButtonType
import kotlinx.html.HTML
import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.id
import kotlinx.html.span

class FantasyWrappedTemplate(
    val wrappedData: WrappedData
) : Template<HTML> {
    override fun HTML.apply() {
        insert(MainTemplate()) {
            body {
                div(classes = "carousel carousel-dark slide") {
                    id = "wrappedCarousel"
                    attributes["data-bs-ride"] = "wrappedCarousel"
                    attributes["data-bs-interval"] = "false"
                    attributes["data-bs-wrap"] = "false"

                    div(classes = "carousel-inner") {
                        attributes["style"] = "padding-left: 10%; padding-right: 10%;"
                        insert(WelcomeCarouselItem(wrappedData)) {}
                        insert(MostPopularCaptainCarouselItem(wrappedData)) {}
                    }
                    button(classes = "carousel-control-prev") {
                        type = ButtonType.button
                        attributes["data-bs-target"] = "#wrappedCarousel"
                        attributes["data-bs-slide"] = "prev"
                        span("carousel-control-prev-icon") {
                            attributes["aria-hidden"] = "true"
                        }
                        span("visually-hidden") { +"Previous" }
                    }
                    button(classes = "carousel-control-next") {
                        type = ButtonType.button
                        attributes["data-bs-target"] = "#wrappedCarousel"
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
