package com.scottwgibson.aflfantasywrapped.templates.home

import com.scottwgibson.aflfantasywrapped.templates.Header
import com.scottwgibson.aflfantasywrapped.templates.MainTemplate
import io.ktor.server.html.Template
import io.ktor.server.html.insert
import kotlinx.html.HTML
import kotlinx.html.InputType
import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.form
import kotlinx.html.h3
import kotlinx.html.input
import kotlinx.html.p
import kotlinx.html.small

class HomePage : Template<HTML> {
    override fun HTML.apply() {
        insert(MainTemplate()) {
            body {
                insert(Header()) {}
                div("container-fluid p-0 wrapped-container vh-100") {
                    form(action = "/search") {
                        div(classes = "input-group d-flex flex-column pt-5 text-white") {
                            div("d-flex align-items-center flex-column") {
                                p() { +"User ID" }
                                div("row col-8") {
                                    input(type = InputType.text, name = "userId") {
                                        placeholder = "Eg. 1758489"
                                    }
                                    small("text-white p-2") {
                                        +"On Web, click 'Account' -> Right Click your team's logo and open image in new tab. Copy the number from the URL"
                                    }
                                }
                                div("row p-3") {
                                    h3 { +"OR" }
                                }
                                p() { +"Share Link" }
                                div("row col-8") {
                                    input(type = InputType.text, name = "sharelink") {
                                        placeholder =
                                            "Eg. https://fantasy.afl.com.au/share/classic_team/eyJjcyI6ImZiIiwidCI6MTY2MDg1MDU5NywidGVhbV9pZCI6MTc1ODQ4OX0="
                                    }
                                    small("text-white p-2") {
                                        +"Hit the 'share' button in the app and copy the URL here"
                                    }
                                }
                                div("row col-4") {
                                    button(classes = "btn btn-primary") {
                                        +"Submit"
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
