package com.scottwgibson.aflfantasywrapped.aflfantasy.models.insights

import com.scottwgibson.aflfantasywrapped.aflfantasy.models.ClassicTeamRound

data class RoundWorth(
    val round: Int,
    val price: Int
)

class CashCowData(
    val trades: SeasonTradeData,
    val rounds: Map<Int, ClassicTeamRound>
) {
    val tradeGains = trades.roundTrades.flatMap { roundTrades ->
        roundTrades.value.tradeOut.map {
            roundTrades.key to it
        }
    }
        .map {
            val roundOut = it.first
            val player = it.second
            val round = rounds.toList()
                .take(roundOut - 1)
                .reversed()
                .dropWhile { it.second.lineup.toSet().contains(player.id) }
                .firstOrNull()
                ?.let { it.first + 1 } ?: 1
            Triple(
                player,
                RoundWorth(round, player.stats.priceAtRound(round)),
                RoundWorth(
                    roundOut,
                    player.stats.priceAtRound(roundOut)
                )
            )
        }
        .sortedByDescending { it.third.price - it.second.price }
}
