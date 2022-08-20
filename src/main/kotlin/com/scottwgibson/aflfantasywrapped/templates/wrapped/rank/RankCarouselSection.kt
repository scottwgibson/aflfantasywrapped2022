package com.scottwgibson.aflfantasywrapped.templates.wrapped.rank

import com.scottwgibson.aflfantasywrapped.models.WrappedData
import com.scottwgibson.aflfantasywrapped.templates.wrapped.misc.CarouselItem
import io.ktor.server.html.Template
import io.ktor.server.html.insert
import kotlinx.html.HtmlBlockTag

class RankCarouselSection(
    val wrappedData: WrappedData
) : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        insert(CarouselItem(OverallRankTemplate(wrappedData))) {}
        insert(CarouselItem(HighestRoundRankTemplate(wrappedData))) {}
    }
}
