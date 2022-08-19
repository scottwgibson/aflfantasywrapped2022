package com.scottwgibson.aflfantasywrapped.templates.wrapped

import com.scottwgibson.aflfantasywrapped.services.WrappedData
import io.ktor.server.html.Template
import kotlinx.html.HtmlBlockTag
import kotlinx.html.a
import kotlinx.html.div
import kotlinx.html.p
import kotlinx.html.script

class EndingCarouselItem(
    val wrappedData: WrappedData
) : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        p(classes = "text-center fs-2") { +"Until next year!" }
        div {
            a("https://twitter.com/share?ref_src=twsrc%5Etfw", classes = "twitter-share-button") {
                attributes["data-show-count"] = "false"
                attributes["data-dnt"] = "true"
                attributes["data-size"] = "large"
                attributes["data-hashtags"] = "aflfantasy"
                attributes["data-text"] = "Unofficial AFL Fantasy Wrapped 2022 - ${wrappedData.snapshot.name}"
                +"Tweet"
            }
            script(src = "https://platform.twitter.com/widgets.js") { }
        }
    }
}
