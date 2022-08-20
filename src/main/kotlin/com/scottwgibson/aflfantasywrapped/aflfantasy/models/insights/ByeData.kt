package com.scottwgibson.aflfantasywrapped.aflfantasy.models.insights

import com.scottwgibson.aflfantasywrapped.aflfantasy.models.ClassicTeamRound
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.ClassicTeamSnapshot
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.Player
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.PlayerId
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.roundScore

class ByeData(
    val playerData: Map<PlayerId, Player>,
    val rounds: Map<Int, ClassicTeamRound>,
    val snapshot: ClassicTeamSnapshot
) {
    val rankChange: Int? = snapshot.rankHistory["14"]?.let { snapshot.rankHistory["11"]?.minus(it) }

    val playersPerRound: Map<Int, Int> = rounds
        .filterKeys { setOf(12, 13, 14).contains(it) }
        .mapValues { roundTeam ->
            roundTeam.value.lineup.toSet()
                .mapNotNull { id -> playerData[id] }
                .count { player -> (player.roundScore(roundTeam.key) ?: 0) > 0 }
        }
}
