package com.scottwgibson.aflfantasywrapped.templates.wrapped.captains

import com.scottwgibson.aflfantasywrapped.aflfantasy.models.insights.SeasonCaptainData
import com.scottwgibson.aflfantasywrapped.services.WrappedData
import io.ktor.server.html.Template
import kotlinx.html.HtmlBlockTag
import kotlinx.html.div
import kotlinx.html.img
import kotlinx.html.p

class MostPopularCaptainCarouselItem(
    private val wrappedData: WrappedData
) : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        val data = SeasonCaptainData(wrappedData.playerStats, wrappedData.rounds)
        val player = data.orderedByUsedDesc().first().first
        val selections = data.orderedByUsedDesc().first().second.count()

        div(classes = "container") {
            div(classes = "row") {
                div(classes = "col col-lg-4") {
                    val url = "https://fantasy.afl.com.au/assets/media/players/afl/${player.id}_450.webp"
                    img(classes = "d-block w-100", src = url)
                    p(classes = "text-center fs-2") {
                        +"${player.firstName} ${player.lastName} was your most selected captain for a total of $selections times."
                    }
                }
            }
        }
    }
}
