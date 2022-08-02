package com.scottwgibson.aflfantasywrapped.services

import com.scottwgibson.aflfantasywrapped.aflfantasy.models.ClassicTeamRound
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.ClassicTeamSnapshot
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.Player
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.PlayerId
import kotlinx.serialization.ExperimentalSerializationApi

@OptIn(ExperimentalSerializationApi::class)
data class WrappedData(
    val playerStats: Map<PlayerId, Player>,
    val rounds: Map<Int, ClassicTeamRound>,
    val snapshot: ClassicTeamSnapshot
)

@OptIn(ExperimentalSerializationApi::class)
object FantasyWrappedService {
    fun createWrapped(
        playerData: Map<PlayerId, Player>,
        rounds: Map<Int, ClassicTeamRound>,
        snapshot: ClassicTeamSnapshot
    ): WrappedData {
        return WrappedData(
            playerData,
            rounds,
            snapshot
        )
    }
}
