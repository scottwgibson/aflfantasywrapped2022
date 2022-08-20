package com.scottwgibson.aflfantasywrapped.templates.wrapped.rank

import com.scottwgibson.aflfantasywrapped.models.WrappedData
import io.ktor.server.html.Template
import kotlinx.html.HtmlBlockTag
import kotlinx.html.br
import kotlinx.html.div
import kotlinx.html.p

class HighestRoundRankTemplate(
    val wrappedData: WrappedData
) : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        val roundRank = wrappedData.snapshot.roundRankHistory.toList().minBy { it.second }
        val peakOverall = wrappedData.snapshot.rankHistory.toList().minBy { it.second }

        div(classes = "text-center fs-3") {
            div { +"Your best round rank was in Round ${roundRank.first}" }
            p(classes = "font-weight-bold fs-1") { +"#${roundRank.second}" }
        }
        br { }
        div(classes = "text-center fs-3") {
            div { +"Your best overall rank was in Round ${peakOverall.first}" }
            p(classes = "font-weight-bold fs-1") { +"#${peakOverall.second}" }
        }
    }
}
