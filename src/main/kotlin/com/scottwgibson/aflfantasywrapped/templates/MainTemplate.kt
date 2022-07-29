package com.scottwgibson.aflfantasywrapped.templates

import io.ktor.server.html.Placeholder
import io.ktor.server.html.Template
import io.ktor.server.html.insert
import kotlinx.html.HTML
import kotlinx.html.HtmlBlockTag
import kotlinx.html.body
import kotlinx.html.head
import kotlinx.html.link
import kotlinx.html.meta
import kotlinx.html.script
import kotlinx.html.title

class MainTemplate : Template<HTML> {
    val body = Placeholder<HtmlBlockTag>()

    override fun HTML.apply() {
        head {
            title("Unofficial AFL Fantasy Wrapped 2022")

            meta {
                charset = "utf-8"
            }

            meta {
                name = "viewport"
                content = "width=device-width, initial-scale=1 shrink-to-fit=yes"
            }

            // Bootstrap
            link(rel = "stylesheet") {
                href = "https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
                integrity = "sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
                attributes["crossorigin"] = "anonymous"
            }

            script {
                src = "https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                integrity = "sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
                attributes["crossorigin"] = "anonymous"
            }

            // Fontawesome

            link(rel = "stylesheet") {
                href = "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
            }

            link(rel = "stylesheet") {
                href = "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/brands.min.css"
            }
        }
        body {
            insert(body)
        }
    }
}
