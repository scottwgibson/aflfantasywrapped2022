package com.scottwgibson.aflfantasywrapped.templates.home

import com.scottwgibson.aflfantasywrapped.templates.MainTemplate
import io.ktor.server.html.Template
import io.ktor.server.html.insert
import kotlinx.html.HTML
import kotlinx.html.br
import kotlinx.html.div
import kotlinx.html.h1
import kotlinx.html.p

class Home2022Page() : Template<HTML> {
    override fun HTML.apply() {
        insert(MainTemplate()) {
            body {
                div(classes = "container mt-4") {
                    div(classes = "row justify-content-center") {
                        div(classes = "col-md-8") {
                            h1 {
                                +"Unofficial AFL Fantasy Wrapped 2022"
                            }
                            p {
                                br {}
                                +"Enter Team ID."
                            }
                        }
                    }

                    div(classes = "container mt-4") {
                        div(classes = "row justify-content-md-center mb-2") {
                            div(classes = "col-8") {
                                insert(TeamIDForm()) {}
                            }
                        }
                    }
                }
            }
        }
    }
}
