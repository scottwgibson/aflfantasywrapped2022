package com.scottwgibson.aflfantasywrapped.templates.wrapped.misc

import io.ktor.server.html.Template
import kotlinx.html.HtmlBlockTag
import kotlinx.html.div
import kotlinx.html.p

class TextCarouselTemplate(
    val text: String
) : Template<HtmlBlockTag> {

    override fun HtmlBlockTag.apply() {
        div(classes = "text-center") {
            p(classes = "fs-3") { +text }
        }
    }
}
