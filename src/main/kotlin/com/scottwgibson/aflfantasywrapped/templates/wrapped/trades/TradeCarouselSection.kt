package com.scottwgibson.aflfantasywrapped.templates.wrapped.trades

import com.scottwgibson.aflfantasywrapped.services.WrappedData
import com.scottwgibson.aflfantasywrapped.templates.wrapped.misc.CarouselItem
import com.scottwgibson.aflfantasywrapped.templates.wrapped.misc.TextCarouselTemplate
import io.ktor.server.html.Template
import io.ktor.server.html.insert
import kotlinx.html.HtmlBlockTag

class TradeCarouselSection(
    val wrappedData: WrappedData
) : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        insert(
            CarouselItem(
                TextCarouselTemplate(
                    "Who gave the biggest scores on debut?"
                )
            )
        ) {}
        insert(CarouselItem(InstantRewardTradeTemplate(wrappedData.seasonTradeData))) {}
    }
}
