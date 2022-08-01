package com.scottwgibson.aflfantasywrapped.templates.insights

import com.scottwgibson.aflfantasywrapped.services.WrappedData
import io.ktor.server.html.Template
import kotlinx.html.HtmlBlockTag
import kotlinx.html.div
import kotlinx.html.p

class MostPopularCaptainCarouselItem(val wrappedData: WrappedData) : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        val player = wrappedData.popularCaptain.first
        val selections = wrappedData.popularCaptain.second
        div(classes = "carousel-item") {
            div(classes = "d-flex align-items-center justify-content-center min-vh-100") {
                p(classes = "text-center fs-2") { +"${player.firstName} ${player.lastName} was your most selected captain for a total of $selections times." }
            }
        }
    }
}
