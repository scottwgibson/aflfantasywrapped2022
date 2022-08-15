package com.scottwgibson.aflfantasywrapped.templates.wrapped.rank

import com.scottwgibson.aflfantasywrapped.services.WrappedData
import io.ktor.server.html.Template
import kotlinx.html.HtmlBlockTag
import kotlinx.html.div
import kotlinx.html.p

class HighestRoundRankTemplate(
    val wrappedData: WrappedData
) : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        val round = wrappedData.snapshot.roundRankHistory.toList().minBy { it.second }

        div(classes = "text-center fs-3") {
            p { +"Your best round was in Round ${round.first} when you ranked" }
            p(classes = "font-weight-bold fs-1") { +"#${round.second}" }
        }
    }
}
