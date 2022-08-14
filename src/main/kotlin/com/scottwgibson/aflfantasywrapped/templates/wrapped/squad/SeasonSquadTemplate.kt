package com.scottwgibson.aflfantasywrapped.templates.wrapped.squad

import com.scottwgibson.aflfantasywrapped.services.WrappedData
import io.ktor.server.html.Template
import kotlinx.html.HtmlBlockTag
import kotlinx.html.div
import kotlinx.html.h1
import kotlinx.html.img

class SeasonSquadTemplate(
    val wrappedData: WrappedData
) : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        val players = wrappedData.rounds.values.first().lineup.toSet()

        div(classes = "container") {
            div("row") {
                div("col text-center") {
                    h1 { +"Your Starting Squad" }
                }
            }
            players.chunked(5)
                .forEach {
                    div("row") {
                        it.forEach {
                            div("col") {
                                img(classes = "img-fluid") {
                                    src = "//fantasy.afl.com.au/assets/media/players/afl/${it}_450.webp"
                                }
                            }
                        }
                    }
                }
        }
    }
}
