package com.scottwgibson.aflfantasywrapped.templates

import io.ktor.server.html.Template
import kotlinx.html.HtmlBlockTag
import kotlinx.html.a
import kotlinx.html.div
import kotlinx.html.header
import kotlinx.html.li
import kotlinx.html.main
import kotlinx.html.span
import kotlinx.html.ul

class Header : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        main {
            div("container-fluid p-0") {
                header("d-flex flex-wrap justify-content-center p-3 bg-dark text-white") {
                    a(
                        href = "/",
                        classes = "d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none"
                    ) {
                        // vg("bi me-2", "#bootstrap")
                        span("fs-5") { +"2022 Unofficial AFL Fantasy Wrapped " }
                    }
                    ul("nav nav-pills mx-3") {
                        li("nav-item") {
                            a("/", classes = "nav-link active") {
                                +"Home"
                            }
                        }
                        li("nav-item") {
                            a("/about", classes = "nav-link") {
                                +"About"
                            }
                        }
                    }
                }
            }
        }
    }
}
/**
val test = """
<nav class="navbar navbar-expand-lg bg-light">
<div class="container-fluid">
<a class="navbar-brand" href="#">Navbar</a>
<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
<span class="navbar-toggler-icon"></span>
</button>
<div class="collapse navbar-collapse" id="navbarSupportedContent">
<ul class="navbar-nav me-auto mb-2 mb-lg-0">
<li class="nav-item">
<a class="nav-link active" aria-current="page" href="#">Home</a>
</li>
<li class="nav-item">
<a class="nav-link" href="#">Link</a>
</li>
<li class="nav-item dropdown">
<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
Dropdown
</a>
<ul class="dropdown-menu">
<li><a class="dropdown-item" href="#">Action</a></li>
<li><a class="dropdown-item" href="#">Another action</a></li>
<li><hr class="dropdown-divider"></li>
<li><a class="dropdown-item" href="#">Something else here</a></li>
</ul>
</li>
<li class="nav-item">
<a class="nav-link disabled">Disabled</a>
</li>
</ul>
<form class="d-flex" role="search">
<input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
<button class="btn btn-outline-success" type="submit">Search</button>
</form>
</div>
</div>
</nav>"""
 **/
