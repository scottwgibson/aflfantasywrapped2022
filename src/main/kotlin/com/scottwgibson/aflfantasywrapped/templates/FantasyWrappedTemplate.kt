package com.scottwgibson.aflfantasywrapped.templates

import com.scottwgibson.aflfantasywrapped.services.WrappedData
import com.scottwgibson.aflfantasywrapped.templates.wrapped.WelcomeCarouselItem
import com.scottwgibson.aflfantasywrapped.templates.wrapped.captains.HighestCaptainsScoreTemplate
import com.scottwgibson.aflfantasywrapped.templates.wrapped.captains.MostPopularCaptainCarouselItem
import com.scottwgibson.aflfantasywrapped.templates.wrapped.captains.MostUsedLoopholeTemplate
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
            div(classes = "d-flex flex-column justify-content-center min-vh-100") {
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
                div(classes = "container-fluid") {
                    attributes["max-width"] = "600px"
                    div(classes = "row") {
                        div(classes = "col min-vh-100") {
                            div(classes = "carousel carousel-dark slide") {
                                id = "wrappedCarousel"
                                attributes["data-bs-ride"] = "wrappedCarousel"
                                attributes["data-bs-interval"] = "false"
                                attributes["data-bs-wrap"] = "false"

                                div(classes = "carousel-inner bg-info") {
                                    attributes["style"] = "padding-left: 5%; padding-right: 5%;"
                                    insert(CarouselItem(WelcomeCarouselItem(wrappedData), true)) {}
                                    insert(CarouselItem(MostPopularCaptainCarouselItem(wrappedData))) {}
                                    insert(CarouselItem(TopCaptainSelectionTemplate(wrappedData.captainData))) {}
                                    insert(CarouselItem(HighestCaptainsScoreTemplate(wrappedData.captainData))) {}
                                    insert(CarouselItem(SeasonSquadTemplate(wrappedData))) {}
                                    insert(CarouselItem(MostUsedLoopholeTemplate(wrappedData.captainData))) {}
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
