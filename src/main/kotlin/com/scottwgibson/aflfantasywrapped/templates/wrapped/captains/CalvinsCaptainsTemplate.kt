package com.scottwgibson.aflfantasywrapped.templates.wrapped.captains

import com.scottwgibson.aflfantasywrapped.aflfantasy.models.insights.SeasonCaptainData
import io.ktor.server.html.Template
import kotlinx.html.HtmlBlockTag
import kotlinx.html.div
import kotlinx.html.p

class CalvinsCaptainsTemplate(
    private val captainData: SeasonCaptainData
) : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        val times = captainData.timesUsingCalvinsTop3()

        div(classes = "text-center") {
            p(classes = "fs-2") { +"Your captains appeared in Calvin's Top 3 a total of $times times." }
        }
    }
}
