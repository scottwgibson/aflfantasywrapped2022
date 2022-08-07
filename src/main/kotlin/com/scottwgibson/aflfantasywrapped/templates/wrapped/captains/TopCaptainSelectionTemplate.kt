package com.scottwgibson.aflfantasywrapped.templates.wrapped.captains

import com.scottwgibson.aflfantasywrapped.aflfantasy.models.insights.SeasonCaptainData
import io.ktor.server.html.Template
import io.ktor.server.html.insert
import kotlinx.html.HtmlBlockTag
import kotlinx.html.div
import kotlinx.html.h1

class TopCaptainSelectionTemplate(
    private val captainData: SeasonCaptainData
) : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        div(classes = "container text-center") {
            div(classes = "row") {
                div(classes = "col text-center") {
                    h1 { +"Most Used Captains" }
                }
            }
            captainData.orderedByUsedDesc().take(5).forEachIndexed { i, it ->
                insert(CaptainRowTemplate(i + 1, it.first, it.second.size.toString())) {}
            }
        }
    }
}
