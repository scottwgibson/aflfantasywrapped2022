package com.scottwgibson.aflfantasywrapped.templates

import com.scottwgibson.aflfantasywrapped.services.WrappedData
import com.scottwgibson.aflfantasywrapped.templates.wrapped.WelcomeCarouselItem
import com.scottwgibson.aflfantasywrapped.templates.wrapped.captains.HighestScoreCaptainsTemplate
import com.scottwgibson.aflfantasywrapped.templates.wrapped.captains.MostPopularCaptainCarouselItem
import com.scottwgibson.aflfantasywrapped.templates.wrapped.captains.TopCaptainSelectionTemplate
import com.scottwgibson.aflfantasywrapped.templates.wrapped.squad.SeasonSquadTemplate
import io.ktor.server.html.Template
import io.ktor.server.html.insert
import kotlinx.html.ButtonType
import kotlinx.html.HTML
import kotlinx.html.HtmlBlockTag
import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.id
import kotlinx.html.span

class CarouselItem<T : Template<HtmlBlockTag>>(
    private val type: T,
    private val active: Boolean = false
) : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        val classes = if (active) "carousel-item active" else "carousel-item"
        div(classes = classes) {
            div(classes = "d-flex align-items-center justify-content-center min-vh-100") {
                insert(type) {}
            }
        }
    }
}

class FantasyWrappedTemplate(
    val wrappedData: WrappedData
) : Template<HTML> {
    override fun HTML.apply() {
        insert(MainTemplate()) {
            body {
                div(classes = "container") {
                    div(classes = "row") {
                        div(classes = "col") {
                            div(classes = "carousel carousel-dark slide") {
                                id = "wrappedCarousel"
                                attributes["data-bs-ride"] = "wrappedCarousel"
                                attributes["data-bs-interval"] = "false"
                                attributes["data-bs-wrap"] = "false"

                                div(classes = "carousel-inner bg-info") {
                                    attributes["style"] = "padding-left: 10%; padding-right: 10%;"
                                    insert(CarouselItem(WelcomeCarouselItem(wrappedData), true)) {}
                                    insert(CarouselItem(MostPopularCaptainCarouselItem(wrappedData))) {}
                                    insert(CarouselItem(TopCaptainSelectionTemplate(wrappedData.captainData))) {}
                                    insert(CarouselItem(HighestScoreCaptainsTemplate(wrappedData.captainData))) {}
                                    insert(CarouselItem(SeasonSquadTemplate(wrappedData))) {}
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
        }
    }
}
