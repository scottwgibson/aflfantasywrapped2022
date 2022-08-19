package com.scottwgibson.aflfantasywrapped.templates.about

import com.scottwgibson.aflfantasywrapped.templates.Header
import com.scottwgibson.aflfantasywrapped.templates.MainTemplate
import io.ktor.server.html.Template
import io.ktor.server.html.insert
import kotlinx.html.HTML
import kotlinx.html.div
import kotlinx.html.p

class AboutPage : Template<HTML> {
    override fun HTML.apply() {
        insert(MainTemplate()) {
            body {
                insert(Header()) {}
                div("container-fluid text-white p-0 wrapped-container vh-100") {
                    div("d-flex align-items-center p-2 flex-column") {
                        p { +"Created by Scott Gibson" }
                        p { +"Unofficial fan project not associated with the AFL" }
                    }
                }
            }
        }
    }
}

// <a href="https://twitter.com/share?ref_src=twsrc%5Etfw" class="twitter-share-button" data-size="large" data-text="Test" data-hashtags="#aflfantasy" data-dnt="true" data-show-count="false">Tweet</a><script async src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>
