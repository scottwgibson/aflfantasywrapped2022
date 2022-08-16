package com.scottwgibson.aflfantasywrapped.templates.wrapped.misc

import com.scottwgibson.aflfantasywrapped.aflfantasy.models.PlayerId
import io.ktor.server.html.Template
import kotlinx.html.HtmlBlockTag
import kotlinx.html.div
import kotlinx.html.img

class PlayerGridTemplate(
    val players: Iterable<PlayerId>,
    val numCol: Int
) : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        players.chunked(numCol)
            .forEach {
                div("row g-0") {
                    it.forEach {
                        div(classes = "col d-flex justify-content-center") {
                            img(classes = "img-fluid player-grid-img") {
                                src = "//fantasy.afl.com.au/assets/media/players/afl/${it}_450.webp"
                            }
                        }
                    }
                }
            }
    }
}
