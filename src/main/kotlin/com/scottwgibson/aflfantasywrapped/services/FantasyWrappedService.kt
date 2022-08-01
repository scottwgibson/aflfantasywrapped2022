package com.scottwgibson.aflfantasywrapped.services

import com.scottwgibson.aflfantasywrapped.aflfantasy.models.ClassicTeamRound
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.ClassicTeamSnapshot
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.Player
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.PlayerId
import kotlinx.serialization.ExperimentalSerializationApi

@OptIn(ExperimentalSerializationApi::class)
data class WrappedData(
    val teamSnapshot: ClassicTeamSnapshot,
    val popularCaptain: Pair<Player, Int>
)

@OptIn(ExperimentalSerializationApi::class)
object FantasyWrappedService {
    fun createWrapped(
        playerStats: Map<PlayerId, Player>,
        rounds: Map<Int, ClassicTeamRound>,
        snapshot: ClassicTeamSnapshot
    ): WrappedData {
        return WrappedData(
            snapshot,
            rounds.map { it.value.lineup.captain }
                .groupingBy { it }.eachCount().maxBy { it.value }
                .let { Pair(playerStats[it.key]!!, it.value) }
        )
    }
}
