package com.scottwgibson.aflfantasywrapped.aflfantasy.models.insights

import com.scottwgibson.aflfantasywrapped.aflfantasy.models.ClassicTeamRound
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.Player
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.PlayerId

class PopularCaptainsInsight(
    playerData: Map<PlayerId, Player>,
    rounds: Map<Int, ClassicTeamRound>
) {
    val captains: List<Pair<Player, Int>>

    init {
        captains = rounds.map { it.value.lineup.captain }
            .groupBy { it }
            .mapKeys { playerData[it.key] ?: throw Exception("Missing Player Data ${it.key}") }
            .mapValues { it.value.count() }
            .toList()
            .sortedByDescending { it.second }
            .take(5)
    }
}
