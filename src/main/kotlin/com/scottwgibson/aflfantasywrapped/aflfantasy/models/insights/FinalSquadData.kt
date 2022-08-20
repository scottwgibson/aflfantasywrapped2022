package com.scottwgibson.aflfantasywrapped.aflfantasy.models.insights

import com.scottwgibson.aflfantasywrapped.aflfantasy.models.ClassicTeamRound
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.Player
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.PlayerId

class FinalSquadData(
    val playerData: Map<PlayerId, Player>,
    val rounds: Map<Int, ClassicTeamRound>
) {
    fun starting22ByUniqueness() =
        rounds.values.last()
            .lineup
            .starting22()
            .mapNotNull { playerData[it] }
            .sortedBy { it.stats.ownedBy }
}
