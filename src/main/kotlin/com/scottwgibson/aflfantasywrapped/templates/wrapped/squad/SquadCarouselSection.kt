package com.scottwgibson.aflfantasywrapped.templates.wrapped.squad

import com.scottwgibson.aflfantasywrapped.services.WrappedData
import com.scottwgibson.aflfantasywrapped.templates.wrapped.misc.CarouselItem
import com.scottwgibson.aflfantasywrapped.templates.wrapped.misc.TextCarouselTemplate
import io.ktor.server.html.Template
import io.ktor.server.html.insert
import kotlinx.html.HtmlBlockTag

class SquadCarouselSection(
    val wrappedData: WrappedData
) : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        insert(
            CarouselItem(
                TextCarouselTemplate(
                    "Here's how your team looked at the end of the season"
                )
            )
        ) {}
        insert(CarouselItem(FinalSquadTemplate(wrappedData))) {}
        insert(
            CarouselItem(
                TextCarouselTemplate(
                    "Just how unique was your final starting 22?"
                )
            )
        ) {}
        insert(CarouselItem(UniqueTableTemplate(wrappedData.finalSquadData))) {}
        insert(
            CarouselItem(
                TextCarouselTemplate(
                    "Let's take a look at your round 1 team"
                )
            )
        ) {}
        insert(CarouselItem(StartingSquadTemplate(wrappedData))) {}
        insert(
            CarouselItem(
                TextCarouselTemplate(
                    "Just how many made it till the end?"
                )
            )
        ) {}
        insert(CarouselItem(RemainingStartingSquadTemplate(wrappedData))) {}
    }
}
