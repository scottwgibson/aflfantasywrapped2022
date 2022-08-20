package com.scottwgibson.aflfantasywrapped.templates

import com.scottwgibson.aflfantasywrapped.models.WrappedData
import com.scottwgibson.aflfantasywrapped.templates.wrapped.EndingCarouselItem
import com.scottwgibson.aflfantasywrapped.templates.wrapped.WelcomeCarouselItem
import com.scottwgibson.aflfantasywrapped.templates.wrapped.byes.ByeCarouselSection
import com.scottwgibson.aflfantasywrapped.templates.wrapped.captains.CaptainCarouselSection
import com.scottwgibson.aflfantasywrapped.templates.wrapped.misc.CarouselItem
import com.scottwgibson.aflfantasywrapped.templates.wrapped.rank.RankCarouselSection
import com.scottwgibson.aflfantasywrapped.templates.wrapped.squad.SquadCarouselSection
import com.scottwgibson.aflfantasywrapped.templates.wrapped.trades.TradeCarouselSection
import io.ktor.server.html.Template
import io.ktor.server.html.insert
import kotlinx.html.ButtonType
import kotlinx.html.HTML
import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.head
import kotlinx.html.id
import kotlinx.html.meta
import kotlinx.html.span

class FantasyWrappedTemplate(
    val wrappedData: WrappedData,
    val shareUrl: String
) : Template<HTML> {
    override fun HTML.apply() {
        insert(MainTemplate()) {
            head {
                meta(name = "twitter:card", content = "summary") { }
                meta(name = "twitter:title", content = "${wrappedData.snapshot.name} 2022 Wrapped") { }
                meta(name = "twitter:description", content = " Unofficial AFL Fantasy season review") { }
            }
            body {
                div(classes = "container-fluid wrapped-container text-white") {
                    div(classes = "row") {
                        div(classes = "col min-vh-100") {
                            div(classes = "carousel slide") {
                                id = "wrappedCarousel"
                                attributes["data-bs-ride"] = "wrappedCarousel"
                                attributes["data-bs-interval"] = "false"
                                attributes["data-bs-wrap"] = "false"

                                div(classes = "carousel-inner") {
                                    attributes["style"] = "padding-left: 8%; padding-right: 8%;"
                                    insert(CarouselItem(WelcomeCarouselItem(wrappedData), true)) {}
                                    insert(RankCarouselSection(wrappedData)) {}
                                    insert(SquadCarouselSection(wrappedData)) {}
                                    insert(CaptainCarouselSection(wrappedData)) {}
                                    insert(ByeCarouselSection(wrappedData)) {}
                                    insert(TradeCarouselSection(wrappedData)) {}
                                    insert(CarouselItem(EndingCarouselItem(wrappedData, shareUrl))) {}
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
