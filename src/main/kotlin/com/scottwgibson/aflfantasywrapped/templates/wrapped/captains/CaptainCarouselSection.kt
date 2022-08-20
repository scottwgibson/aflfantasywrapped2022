package com.scottwgibson.aflfantasywrapped.templates.wrapped.captains

import com.scottwgibson.aflfantasywrapped.models.WrappedData
import com.scottwgibson.aflfantasywrapped.templates.wrapped.misc.CarouselItem
import com.scottwgibson.aflfantasywrapped.templates.wrapped.misc.TextCarouselTemplate
import io.ktor.server.html.Template
import io.ktor.server.html.insert
import kotlinx.html.HtmlBlockTag

class CaptainCarouselSection(
    val wrappedData: WrappedData
) : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        insert(
            CarouselItem(
                TextCarouselTemplate(
                    "Arrr! Lets talk captains \uD83C\uDFF4\u200D☠️️ \n"
                )
            )
        ) {}
        insert(CarouselItem(TopCaptainSelectionTemplate(wrappedData.captainData))) {}
        insert(
            CarouselItem(
                TextCarouselTemplate(
                    "Who were your best?"
                )
            )
        ) {}
        insert(CarouselItem(HighestCaptainsScoreTemplate(wrappedData.captainData))) {}
        insert(
            CarouselItem(
                TextCarouselTemplate(
                    "And the rest?"
                )
            )
        ) {}
        insert(CarouselItem(LowestCaptainScoreTemplate(wrappedData.captainData))) {}
        insert(
            CarouselItem(
                TextCarouselTemplate(
                    "The Vice Captain loophole was popular this year, but how much did you take advantage of it?"
                )
            )
        ) {}
        insert(CarouselItem(MostUsedLoopholeTemplate(wrappedData.captainData))) {}
        insert(CarouselItem(CalvinsCaptainsTemplate(wrappedData.captainData))) {}
    }
}
