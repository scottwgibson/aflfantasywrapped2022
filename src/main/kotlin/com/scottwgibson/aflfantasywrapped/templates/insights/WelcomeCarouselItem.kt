package com.scottwgibson.aflfantasywrapped.templates.insights

import com.scottwgibson.aflfantasywrapped.services.WrappedData
import io.ktor.server.html.Template
import kotlinx.html.HtmlBlockTag
import kotlinx.html.div
import kotlinx.html.p

class WelcomeCarouselItem(
    val wrappedData: WrappedData
) : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        div(classes = "carousel-item active") {
            div(classes = "d-flex align-items-center justify-content-center min-vh-100") {
                p(classes = "text-center fs-2") { +"Welcome ${wrappedData.teamSnapshot.name}, here is your unofficial AFL Fantasy Classic 2022 Wrapped" }
            }
        }
    }
}
