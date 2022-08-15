package com.scottwgibson.aflfantasywrapped.templates.wrapped.rank

import com.scottwgibson.aflfantasywrapped.services.WrappedData
import com.scottwgibson.aflfantasywrapped.templates.wrapped.misc.CarouselItem
import com.scottwgibson.aflfantasywrapped.templates.wrapped.misc.TextCarouselTemplate
import io.ktor.server.html.Template
import io.ktor.server.html.insert
import kotlinx.html.HtmlBlockTag

class RankCarouselSection(
    val wrappedData: WrappedData
) : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        insert(
            CarouselItem(
                TextCarouselTemplate(
                    "Lets take a look at how you did"
                )
            )
        ) {}
        insert(CarouselItem(OverallRankTemplate(wrappedData))) {}
        insert(CarouselItem(HighestRoundRankTemplate(wrappedData))) {}
    }
}
