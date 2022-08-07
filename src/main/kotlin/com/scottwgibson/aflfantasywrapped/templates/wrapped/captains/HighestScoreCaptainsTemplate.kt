package com.scottwgibson.aflfantasywrapped.templates.wrapped.captains

import com.scottwgibson.aflfantasywrapped.aflfantasy.models.Player
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.insights.SeasonCaptainData
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.name
import io.ktor.server.html.Template
import io.ktor.server.html.insert
import kotlinx.html.HtmlBlockTag
import kotlinx.html.div
import kotlinx.html.h1
import kotlinx.html.img

class CaptainScoreRowTemplate(
    val score: Int,
    val player: Player,
    val bracketData: String? = null
) : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        div(classes = "row align-items-center") {
            div(classes = "col col-2 text-center") {
                h1 { +"$score" }
            }
            div(classes = "col col-4") {
                val url = "https://fantasy.afl.com.au/assets/media/players/afl/${player.id}_450.webp"
                img(classes = "d-block img-fluid", src = url)
            }
            div(classes = "col text-center") {
                div(classes = "container text-center") {
                    div(classes = "row align-items-center") {
                        +player.name()
                    }
                    bracketData?.let {
                        div(classes = "row") {
                            +"($bracketData)"
                        }
                    }
                }
            }
        }
    }
}

class HighestScoreCaptainsTemplate(
    private val captainData: SeasonCaptainData
) : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        div(classes = "container text-center") {
            div(classes = "row") {
                div(classes = "col text-center") {
                    h1 { +"Highest Scoring Captains" }
                }
            }

            captainData.orderedByScoreDesc().take(5).forEachIndexed { i, it ->
                val score = it.finalCaptainScore()
                val selectedAs = if (it.loopholeUsed()) "VC" else "C"
                val round = it.round
                val bracketData = "R$round $selectedAs"
                insert(CaptainScoreRowTemplate(score, it.finalCaptain(), bracketData)) {}
            }
        }
    }
}
