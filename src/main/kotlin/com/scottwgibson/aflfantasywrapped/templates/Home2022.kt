package com.scottwgibson.aflfantasywrapped.templates

import io.ktor.server.html.Template
import io.ktor.server.html.insert
import kotlinx.html.HTML
import kotlinx.html.br
import kotlinx.html.div
import kotlinx.html.h1
import kotlinx.html.p

class Home2022() : Template<HTML> {
    override fun HTML.apply() {
        insert(MainTemplate()) {
            body {
                div(classes = "container mt-4") {
                    div(classes = "row justify-content-center") {
                        div(classes = "col-md-4") {
                            h1 {
                                +"Unofficial AFL Fantasy Wrapped 2022"
                            }
                            p {
                                br {}
                                +"Enter Team ID."
                            }
                        }
                    }
                }
            }
        }
    }
}
