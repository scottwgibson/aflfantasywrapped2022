package com.scottwgibson.aflfantasywrapped.templates.wrapped.captains

import com.scottwgibson.aflfantasywrapped.aflfantasy.models.Player
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.name
import io.ktor.server.html.Template
import kotlinx.html.HtmlBlockTag
import kotlinx.html.div
import kotlinx.html.h2
import kotlinx.html.img

class CaptainRowTemplate(
    val position: Int,
    val player: Player,
    val bracketData: String? = null
) : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        div(classes = "row align-items-center") {
            div(classes = "col col-2 text-center") {
                h2 { +"#$position" }
            }
            div(classes = "col col-4") {
                val url = "https://fantasy.afl.com.au/assets/media/players/afl/${player.id}_450.webp"
                img(classes = "d-block w-100", src = url)
            }
            div(classes = "col text-center ") {
                val text = bracketData?.let { "${player.name()} ($bracketData)" } ?: player.name()
                +text
            }
        }
    }
}
