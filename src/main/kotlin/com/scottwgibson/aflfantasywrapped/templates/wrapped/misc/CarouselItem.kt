package com.scottwgibson.aflfantasywrapped.templates.wrapped.misc

import io.ktor.server.html.Template
import io.ktor.server.html.insert
import kotlinx.html.HtmlBlockTag
import kotlinx.html.div

class CarouselItem<T : Template<HtmlBlockTag>>(
    private val type: T,
    private val active: Boolean = false
) : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        val classes = if (active) "carousel-item active" else "carousel-item"
        div(classes = classes) {
            div(classes = "d-flex flex-column justify-content-center min-vh-100") {
                insert(type) {}
            }
        }
    }
}
