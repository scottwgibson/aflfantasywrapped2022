package com.scottwgibson.aflfantasywrapped.templates.wrapped

import com.scottwgibson.aflfantasywrapped.models.WrappedData
import io.ktor.server.html.Template
import kotlinx.html.HtmlBlockTag
import kotlinx.html.img
import kotlinx.html.p

class WelcomeCarouselItem(
    val wrappedData: WrappedData
) : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        p(classes = "text-center fs-2") { +"Unofficial AFL Fantasy Classic 2022 Wrapped" }
        img(classes = "img-thumbnail rounded mx-auto d-block avatar-img") {
            src = "https://fantasy.afl.com.au/assets/media/avatars/afl/${wrappedData.userId}.png?v=0"
        }
        p(classes = "text-center fs-2 ") { +wrappedData.snapshot.name }
    }
}
