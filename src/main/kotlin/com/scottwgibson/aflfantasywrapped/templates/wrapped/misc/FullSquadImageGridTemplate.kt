package com.scottwgibson.aflfantasywrapped.templates.wrapped.misc

import com.scottwgibson.aflfantasywrapped.aflfantasy.models.PlayerId
import io.ktor.server.html.Template
import kotlinx.html.HtmlBlockTag
import kotlinx.html.div
import kotlinx.html.img

class FullSquadImageGridTemplate(
    val players: Iterable<PlayerId>
) : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        val itr = players.iterator()
        listOf(3, 4, 4, 4, 4, 4, 4, 3)
            .forEach {
                div("row") {
                    for (i in 1..it) {
                        val playerId = itr.next()
                        div(classes = "col d-flex justify-content-center") {
                            img(classes = "img-fluid player-grid-img") {
                                src = "//fantasy.afl.com.au/assets/media/players/afl/${playerId}_450.webp"
                            }
                        }
                    }
                }
            }
    }
}
