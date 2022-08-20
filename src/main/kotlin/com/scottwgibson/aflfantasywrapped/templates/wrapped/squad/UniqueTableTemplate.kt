package com.scottwgibson.aflfantasywrapped.templates.wrapped.squad

import com.scottwgibson.aflfantasywrapped.aflfantasy.models.insights.FinalSquadData
import com.scottwgibson.aflfantasywrapped.templates.wrapped.misc.PlayerRowTemplate
import io.ktor.server.html.Template
import io.ktor.server.html.insert
import kotlinx.html.HtmlBlockTag
import kotlinx.html.div
import kotlinx.html.h1
import java.math.RoundingMode

class UniqueTableTemplate(
    private val finalSquadData: FinalSquadData
) : Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        div(classes = "container text-center") {
            div(classes = "row") {
                div(classes = "col text-center") {
                    h1 { +"Most Unique on Field" }
                }
            }

            finalSquadData.starting22ByUniqueness().take(5).forEach { player ->
                insert(PlayerRowTemplate(player)) {
                    column1 { +"${player.stats.ownedBy.toBigDecimal().setScale(1, RoundingMode.HALF_UP)}%" }
                    column4 { +"${player.stats.averagePoints} avg." }
                }
            }
        }
    }
}
