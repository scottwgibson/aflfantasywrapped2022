package com.scottwgibson.aflfantasywrapped.templates.error

import com.scottwgibson.aflfantasywrapped.templates.Header
import com.scottwgibson.aflfantasywrapped.templates.MainTemplate
import io.ktor.server.html.Template
import io.ktor.server.html.insert
import kotlinx.html.HTML
import kotlinx.html.br
import kotlinx.html.div
import kotlinx.html.p

class ErrorPage() : Template<HTML> {
    override fun HTML.apply() {
        insert(MainTemplate()) {
            body {
                insert(Header()) {}
                div("container-fluid text-white p-0 wrapped-container vh-100") {
                    div("d-flex align-items-center p-2 flex-column text-center") {
                        p { +"Sorry, something went wrong :(" }
                        p { +"Either the id/link you entered is incorrect, AFL Fantasy is having issues or your team has a situation I didn't account for. " }
                        br {}
                        p { +"Please try again later." }
                    }
                }
            }
        }
    }
}
