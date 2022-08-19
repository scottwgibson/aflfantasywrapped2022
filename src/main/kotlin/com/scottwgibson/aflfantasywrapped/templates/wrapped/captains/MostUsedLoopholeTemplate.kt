package com.scottwgibson.aflfantasywrapped.templates.wrapped.captains

import com.scottwgibson.aflfantasywrapped.aflfantasy.models.insights.SeasonCaptainData
import com.scottwgibson.aflfantasywrapped.templates.wrapped.misc.PlayerRowTemplate
import io.ktor.server.html.Template
import io.ktor.server.html.insert
import kotlinx.html.HtmlBlockTag
import kotlinx.html.div
import kotlinx.html.h1

class MostUsedLoopholeTemplate(
    private val captainData: SeasonCaptainData
) : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        val loopholes = captainData.orderedByLoopholeDesc().take(5)
        div(classes = "container text-center") {
            div(classes = "row") {
                div(classes = "col text-center") {
                    if (loopholes.isEmpty()) {
                        h1 { +"You never used to captain loophole!" }
                    } else {
                        h1 { +"Your popular loophole captains" }
                    }
                }
            }

            loopholes.forEach { player ->
                insert(PlayerRowTemplate(player.first)) {
                    column1 { +"${player.second.size}" }
                }
            }
        }
    }
}
