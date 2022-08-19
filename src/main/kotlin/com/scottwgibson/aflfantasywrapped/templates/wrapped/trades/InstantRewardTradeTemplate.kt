package com.scottwgibson.aflfantasywrapped.templates.wrapped.trades

import com.scottwgibson.aflfantasywrapped.aflfantasy.models.insights.SeasonTradeData
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.roundScore
import com.scottwgibson.aflfantasywrapped.templates.wrapped.misc.PlayerRowTemplate
import io.ktor.server.html.Template
import io.ktor.server.html.insert
import kotlinx.html.HtmlBlockTag
import kotlinx.html.div
import kotlinx.html.h1

class InstantRewardTradeTemplate(
    val seasonTradeData: SeasonTradeData
) : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        val players = seasonTradeData.tradeInsByRoundScoreDesc().take(5)

        div(classes = "container text-center") {
            div(classes = "row") {
                div(classes = "col text-center") {
                    h1 { +"Instant reward trades" }
                }
            }

            players.forEach {
                val round = it.first
                val score = it.second.roundScore(round)
                insert(PlayerRowTemplate(it.second)) {
                    column1 { +"$score" }
                    column4 { +"R$round" }
                }
            }
        }
    }
}
