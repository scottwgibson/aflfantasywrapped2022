package com.scottwgibson.aflfantasywrapped.templates.wrapped.byes

import com.scottwgibson.aflfantasywrapped.models.WrappedData
import com.scottwgibson.aflfantasywrapped.templates.wrapped.misc.CarouselItem
import com.scottwgibson.aflfantasywrapped.templates.wrapped.misc.TextCarouselTemplate
import io.ktor.server.html.Template
import io.ktor.server.html.insert
import kotlinx.html.HtmlBlockTag

class ByeCarouselSection(
    val wrappedData: WrappedData
) : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        insert(
            CarouselItem(
                TextCarouselTemplate(
                    "The byes are a break for players but not for us coaches, how well did you handle them?"
                )
            )
        ) {}
        insert(CarouselItem(ByeRankChangeTemplate(wrappedData.byeData))) {}
    }
}
