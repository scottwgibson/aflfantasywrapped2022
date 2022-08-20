package com.scottwgibson.aflfantasywrapped.templates.wrapped.rank

import com.scottwgibson.aflfantasywrapped.models.WrappedData
import io.ktor.server.html.Template
import kotlinx.html.HtmlBlockTag
import kotlinx.html.div
import kotlinx.html.p

class OverallRankTemplate(
    val wrappedData: WrappedData
) : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        val total = wrappedData.snapshot.numTeams
        div(classes = "text-center fs-3") {
            p { +"Out of $total teams, you placed" }
            p(classes = "font-weight-bold fs-1") { +"#${wrappedData.snapshot.rank}" }
            val rank = wrappedData.snapshot.rank
            val text = when {
                rank <= 1 -> "Congratulations on your new car!"
                rank <= 100 -> "Holy hat, well done!"
                rank <= 500 -> "Congratulations on being top 500!"
                rank <= 1000 -> "Well done on being top 1000!"
                rank <= 2000 -> "Well done on being top 2000!"
                else -> "Well done!"
            }
            p("fs-3") { +text }
        }
    }
}
