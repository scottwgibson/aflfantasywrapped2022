package com.scottwgibson.aflfantasywrapped.templates.wrapped

import com.scottwgibson.aflfantasywrapped.services.WrappedData
import io.ktor.server.html.Template
import kotlinx.html.HtmlBlockTag
import kotlinx.html.p

class WelcomeCarouselItem(
    val wrappedData: WrappedData
) : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {

        p(classes = "text-center fs-2 w-75") { +"Welcome ${wrappedData.snapshot.name}, this is your unofficial AFL Fantasy Classic 2022 Wrapped" }
    }
}
