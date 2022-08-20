package com.scottwgibson.aflfantasywrapped.templates.wrapped.squad

import com.scottwgibson.aflfantasywrapped.models.WrappedData
import com.scottwgibson.aflfantasywrapped.templates.wrapped.misc.PlayerGridTemplate
import io.ktor.server.html.Template
import io.ktor.server.html.insert
import kotlinx.html.HtmlBlockTag
import kotlinx.html.div
import kotlinx.html.h1

class FinalSquadTemplate(
    val wrappedData: WrappedData
) : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        val players = wrappedData.rounds.values.last().lineup.toSet()

        div(classes = "container") {
            div("row") {
                div("col text-center") {
                    h1 { +"Your Final Squad" }
                }
            }

            insert(PlayerGridTemplate(players, 5)) {}
        }
    }
}
