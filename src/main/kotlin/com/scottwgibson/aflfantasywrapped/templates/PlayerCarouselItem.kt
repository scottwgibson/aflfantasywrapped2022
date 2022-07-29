package com.scottwgibson.aflfantasywrapped.templates

import io.ktor.server.html.Template
import kotlinx.html.HtmlBlockTag
import kotlinx.html.div
import kotlinx.html.img

class PlayerCarouselItem(
    val playerId: Int,
    val active: Boolean
) : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        val classes = if (active) {
            "carousel-item active"
        } else {
            "carousel-item"
        }

        div(classes = classes) {
            val url = "https://fantasy.afl.com.au/assets/media/players/afl/${playerId}_450.webp"
            img(classes = "d-block w-100", src = url)
        }
    }
}
