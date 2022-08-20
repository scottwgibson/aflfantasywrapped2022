package com.scottwgibson.aflfantasywrapped.templates.about

import com.scottwgibson.aflfantasywrapped.templates.Header
import com.scottwgibson.aflfantasywrapped.templates.MainTemplate
import io.ktor.server.html.Template
import io.ktor.server.html.insert
import kotlinx.html.HTML
import kotlinx.html.br
import kotlinx.html.div
import kotlinx.html.h2
import kotlinx.html.p

class AboutPage : Template<HTML> {
    override fun HTML.apply() {
        insert(MainTemplate()) {
            body {
                insert(Header()) {}
                div("container-fluid text-white p-0 wrapped-container vh-100") {
                    div("d-flex align-items-center p-2 flex-column text-center") {
                        p { +"Created by Scott Gibson @Gibbo2311" }
                        p { +"Unofficial fan project not associated with the AFL, made using public facing APIs only." }
                        br { }
                        h2 { +"Special Thanks" }
                        p { +"Fantasy Division League Discord" }
                        p { +"The Traders Podcast" }
                    }
                }
            }
        }
    }
}
