package com.scottwgibson.aflfantasywrapped.templates.wrapped

import com.scottwgibson.aflfantasywrapped.models.WrappedData
import io.ktor.server.html.Template
import kotlinx.html.HtmlBlockTag
import kotlinx.html.a
import kotlinx.html.div
import kotlinx.html.h2
import kotlinx.html.li
import kotlinx.html.ul

class EndingCarouselItem(
    val wrappedData: WrappedData
) : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        div("d-flex align-items-center p-2 flex-column") {
            h2 { +"See you next year!" }
            ul("nav nav-pills mx-3") {
                li("nav-item") {
                    a("/", classes = "nav-link active") {
                        +"Home"
                    }
                }
            }
        }
    }
}
