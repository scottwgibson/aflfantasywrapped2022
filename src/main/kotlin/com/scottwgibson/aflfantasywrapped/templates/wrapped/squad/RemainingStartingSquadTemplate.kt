package com.scottwgibson.aflfantasywrapped.templates.wrapped.squad

import com.scottwgibson.aflfantasywrapped.services.WrappedData
import com.scottwgibson.aflfantasywrapped.templates.wrapped.misc.PlayerGridTemplate
import io.ktor.server.html.Template
import io.ktor.server.html.insert
import kotlinx.html.HtmlBlockTag
import kotlinx.html.div
import kotlinx.html.h1

class RemainingStartingSquadTemplate(
    val wrappedData: WrappedData
) : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        val initial = wrappedData.rounds.values.first().lineup.toSet()
        val final = wrappedData.rounds.values.last().lineup.toSet()

        val players = initial.intersect(final)

        div(classes = "container") {
            div("row") {
                div("col text-center") {
                    h1 { +"Your Survivors" }
                }
            }
            val size = players.size
            val cols = when {
                size < 10 -> 3
                size < 20 -> 4
                else -> 5
            }

            insert(PlayerGridTemplate(players, cols)) {}
        }
    }
}
