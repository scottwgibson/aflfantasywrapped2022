package com.scottwgibson.aflfantasywrapped.aflfantasy.models.insights

import com.scottwgibson.aflfantasywrapped.aflfantasy.models.ClassicTeamRound
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.Player
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.PlayerId
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.roundScore

class SeasonTradeData(
    playerData: Map<PlayerId, Player>,
    rounds: Map<Int, ClassicTeamRound>
) {
    val roundTrades: Map<Int, RoundTrades>

    init {
        roundTrades = rounds.mapNotNull {
            val curSquad = it.value.lineup.toSet()
            val prevSquad = rounds[it.key - 1]?.lineup?.toSet()

            prevSquad?.let { prev ->
                val tradeOut = (prev.minus(curSquad)).map { playerId ->
                    playerData[playerId] ?: throw Exception("Missing Player Data $playerId")
                }
                val tradeIn = (curSquad.minus(prev)).map { playerId ->
                    playerData[playerId] ?: throw Exception("Missing Player Data $playerId")
                }
                it.key to RoundTrades(it.key, tradeOut, tradeIn)
            }
        }.toMap()
    }

    fun tradeInsByRoundScoreDesc() = roundTrades.flatMap {
        val round = it.key
        it.value.tradeIn.map { player -> round to player }
    }
        .sortedByDescending { it.second.roundScore(it.first) }
}
