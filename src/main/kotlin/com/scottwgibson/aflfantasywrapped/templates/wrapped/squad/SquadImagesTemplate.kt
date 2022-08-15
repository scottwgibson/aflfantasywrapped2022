package com.scottwgibson.aflfantasywrapped.templates.wrapped.squad

import com.scottwgibson.aflfantasywrapped.aflfantasy.models.PlayerId
import io.ktor.server.html.Template
import kotlinx.html.HtmlBlockTag
import kotlinx.html.div
import kotlinx.html.img

class SquadImagesTemplate(
    val players: Iterable<PlayerId>,
    val numCol: Int
) : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        players.chunked(numCol)
            .forEach {
                div("row") {
                    it.forEach {
                        div(classes = "col") {
                            img(classes = "img-fluid") {
                                // attributes["max-width"] = "100px !important"
                                src = "//fantasy.afl.com.au/assets/media/players/afl/${it}_450.webp"
                            }
                        }
                    }
                }
            }
    }
}
