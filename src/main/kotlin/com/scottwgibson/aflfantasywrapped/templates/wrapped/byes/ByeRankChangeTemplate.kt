package com.scottwgibson.aflfantasywrapped.templates.wrapped.byes

import com.scottwgibson.aflfantasywrapped.aflfantasy.models.insights.ByeData
import io.ktor.server.html.Template
import kotlinx.html.HtmlBlockTag
import kotlinx.html.div
import kotlinx.html.p
import kotlin.math.abs

class ByeRankChangeTemplate(
    private val byeData: ByeData
) : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        val rankChange = byeData.rankChange

        val rankText = when {
            rankChange == null || rankChange == 0 -> "No overall rank change during the byes"
            rankChange > 0 -> "You gained ${abs(rankChange)} spots during the byes"
            rankChange < 0 -> "You slipped ${abs(rankChange)} spots during the byes"
            else -> throw Exception("Unexpected rank state")
        }

        val rnd12 = byeData.playersPerRound[12]?.toString() ?: "??"
        val rnd13 = byeData.playersPerRound[13]?.toString() ?: "??"
        val rnd14 = byeData.playersPerRound[14]?.toString() ?: "??"

        val structureText = "with a $rnd12/$rnd13/$rnd14 structure."

        div(classes = "text-center") {
            p(classes = "fs-2") { +"$rankText $structureText" }
        }
    }
}
