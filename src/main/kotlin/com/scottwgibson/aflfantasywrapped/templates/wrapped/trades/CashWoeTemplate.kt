package com.scottwgibson.aflfantasywrapped.templates.wrapped.trades

import com.scottwgibson.aflfantasywrapped.aflfantasy.models.insights.CashCowData
import com.scottwgibson.aflfantasywrapped.templates.wrapped.misc.PlayerRowTemplate
import io.ktor.server.html.Template
import io.ktor.server.html.insert
import kotlinx.html.HtmlBlockTag
import kotlinx.html.div
import kotlinx.html.h1
import kotlin.math.abs

class CashWoeTemplate(
    val cashCowData: CashCowData
) : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        val players = cashCowData.tradeGains
            .reversed()
            .take(5)

        div(classes = "container text-center") {
            div(classes = "row") {
                div(classes = "col text-center") {
                    h1 { +"Your Cash Woes" }
                }
            }

            players.forEachIndexed { i, cow ->
                val increase = cow.third.price - cow.second.price
                val roundIn = cow.second.round
                val roundOut = cow.third.round
                val prefix = if (increase >= 0) "+" else "-"
                val increaseString = abs(increase).toString().dropLast(3) + "k"
                insert(PlayerRowTemplate(cow.first)) {
                    column1 { +"#${i + 1}" }
                    column4 { +"$prefix\$$increaseString R$roundIn..R$roundOut" }
                }
            }
        }
    }
}
