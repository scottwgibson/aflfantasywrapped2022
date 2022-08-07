package com.scottwgibson.aflfantasywrapped.templates.wrapped

import com.scottwgibson.aflfantasywrapped.services.WrappedData
import io.ktor.server.html.Template
import kotlinx.html.HtmlBlockTag
import kotlinx.html.div
import kotlinx.html.img
import kotlinx.html.onError
import kotlinx.html.p

class WelcomeCarouselItem(
    val wrappedData: WrappedData
) : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        div(classes = "carousel-item active") {
            div(classes = "d-flex align-items-center justify-content-center") {
                p(classes = "text-center fs-2 w-75") { +"Welcome ${wrappedData.snapshot.name}, here is your unofficial AFL Fantasy Classic 2022 Wrapped" }
                img(src = "//fantasy.afl.com.au/assets/media/avatars/afl/${wrappedData.snapshot.id}.png?v=0") {
                    onError = "this.style.display='none'"
                }
            }
        }
    }
}
