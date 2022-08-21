package com.scottwgibson.aflfantasywrapped.templates.wrapped.trades

import com.scottwgibson.aflfantasywrapped.models.WrappedData
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
                    "Lets take a look at how you traded"
                )
            )
        ) {}
        insert(CarouselItem(InstantRewardTradeTemplate(wrappedData.seasonTradeData))) {}
        insert(CarouselItem(HindsightTradeTemplate(wrappedData.seasonTradeData))) {}
        insert(CarouselItem(CashCowTemplate(wrappedData.cashCowData))) {}
        insert(CarouselItem(CashWoeTemplate(wrappedData.cashCowData))) {}
    }
}
