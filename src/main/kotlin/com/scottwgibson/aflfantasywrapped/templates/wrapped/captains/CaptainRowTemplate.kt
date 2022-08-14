package com.scottwgibson.aflfantasywrapped.templates.wrapped.captains

import com.scottwgibson.aflfantasywrapped.aflfantasy.models.Player
import io.ktor.server.html.Placeholder
import io.ktor.server.html.Template
import io.ktor.server.html.insert
import kotlinx.html.FlowContent
import kotlinx.html.HtmlBlockTag
import kotlinx.html.div
import kotlinx.html.h2
import kotlinx.html.img
import kotlinx.html.p

class CaptainRowTemplate(
    val player: Player
) : Template<HtmlBlockTag> {
    val Column1 = Placeholder<FlowContent>()
    val Column3 = Placeholder<FlowContent>()
    override fun HtmlBlockTag.apply() {
        div(classes = "row align-items-center") {
            div(classes = "col col-2 text-center") {
                h2 { insert(Column1) }
            }
            div(classes = "col col-4") {
                val url = "https://fantasy.afl.com.au/assets/media/players/afl/${player.id}_450.webp"
                img(classes = "d-block", src = url) {
                    attributes["width"] = "80px !important"
                }
            }
            div(classes = "col text-center") {
                p { insert(Column3) }
            }
        }
    }
}
