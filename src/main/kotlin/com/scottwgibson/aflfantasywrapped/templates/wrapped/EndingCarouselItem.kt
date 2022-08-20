package com.scottwgibson.aflfantasywrapped.templates.wrapped

import com.scottwgibson.aflfantasywrapped.models.WrappedData
import io.ktor.http.URLProtocol
import io.ktor.http.path
import io.ktor.server.html.Template
import io.ktor.server.util.url
import kotlinx.html.ButtonType
import kotlinx.html.HTMLTag
import kotlinx.html.HtmlBlockTag
import kotlinx.html.HtmlInlineTag
import kotlinx.html.SVG
import kotlinx.html.TagConsumer
import kotlinx.html.a
import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.h2
import kotlinx.html.li
import kotlinx.html.svg
import kotlinx.html.ul
import kotlinx.html.visit

class Path(consumer: TagConsumer<*>) :
    HTMLTag(
        "path",
        consumer,
        emptyMap(),
        inlineTag = true,
        emptyTag = false
    ),
    HtmlInlineTag

fun SVG.path(block: Path.() -> Unit = {}) {
    Path(consumer).visit(block)
}

class EndingCarouselItem(
    val wrappedData: WrappedData,
    private val shareBaseUrl: String
) : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        div("d-flex align-items-center p-2 flex-column") {
            h2 { +"Good luck next year!" }
            ul("nav nav-pills mx-3 p-2") {
                li("nav-item") {
                    a("/", classes = "nav-link active") {
                        +"Home"
                    }
                }
            }

            val shareUrl = url {
                protocol = URLProtocol.HTTPS
                host = "twitter.com"
                path("intent", "tweet")
                parameters.append("text", "${wrappedData.snapshot.name} season 2022 wrapped")
                parameters.append("url", "$shareBaseUrl/user/${wrappedData.userId}")
                parameters.append("hashtags", "aflfantasy,season2022wrapped")
            }

            a(href = shareUrl) {
                button(type = ButtonType.button, classes = "btn btn-primary") {
                    svg("bi bi-twitter") {
                        attributes["width"] = "16"
                        attributes["height"] = "16"
                        attributes["fill"] = "currentColor"
                        attributes["viewBox"] = "0 0 16 16"
                        path {
                            attributes["d"] =
                                "M5.026 15c6.038 0 9.341-5.003 9.341-9.334 0-.14 0-.282-.006-.422A6.685 6.685 0 0 0 16 3.542a6.658 6.658 0 0 1-1.889.518 3.301 3.301 0 0 0 1.447-1.817 6.533 6.533 0 0 1-2.087.793A3.286 3.286 0 0 0 7.875 6.03a9.325 9.325 0 0 1-6.767-3.429 3.289 3.289 0 0 0 1.018 4.382A3.323 3.323 0 0 1 .64 6.575v.045a3.288 3.288 0 0 0 2.632 3.218 3.203 3.203 0 0 1-.865.115 3.23 3.23 0 0 1-.614-.057 3.283 3.283 0 0 0 3.067 2.277A6.588 6.588 0 0 1 .78 13.58a6.32 6.32 0 0 1-.78-.045A9.344 9.344 0 0 0 5.026 15z"
                        }
                    }
                    +"Tweet"
                }
            }
        }
    }
}

// <a href="https://twitter.com/share?ref_src=twsrc%5Etfw" class="twitter-share-button" data-size="large" data-text="Test" data-hashtags="aflfantasy aflfantasywrapped" data-show-count="false">Tweet</a><script async src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>
// <a class="btn-floating btn btn-tw" type="button" role="button" title="Share on twitter"
//    href="https://twitter.com/intent/tweet?url=https%3A%2F%2Fparse.com"
//    rel="noopener">
//   <i class="fab fa-2x fa-twitter"></i>
// </a>
