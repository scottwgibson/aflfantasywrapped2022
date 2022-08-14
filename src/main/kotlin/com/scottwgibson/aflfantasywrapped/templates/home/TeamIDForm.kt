package com.scottwgibson.aflfantasywrapped.templates.home

import io.ktor.server.html.Template
import kotlinx.html.HtmlBlockTag
import kotlinx.html.InputType
import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.form
import kotlinx.html.input

class TeamIDForm : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        form(action = "/team") {
            div(classes = "form-group") {
                div(classes = "input-group") {
                    input(classes = "form-control-lg", type = InputType.text, name = "teamId") {
                        placeholder = "Eg. 10192"
                    }
                    button(classes = "fas fa-search")
                }
            }
        }
    }
}
