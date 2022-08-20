package com.scottwgibson.aflfantasywrapped.models

import com.scottwgibson.aflfantasywrapped.aflfantasy.models.ClassicTeamRound
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.ClassicTeamSnapshot
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.Player
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.PlayerId
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.insights.ByeData
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.insights.CalvinsCaptainsData
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.insights.FinalSquadData
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.insights.SeasonCaptainData
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.insights.SeasonTradeData

data class WrappedData(
    val playerStats: Map<PlayerId, Player>,
    val rounds: Map<Int, ClassicTeamRound>,
    val snapshot: ClassicTeamSnapshot,
    private val calvinsCaptains: CalvinsCaptainsData
) {
    val userId = rounds.values.first().userId
    val captainData = SeasonCaptainData(playerStats, rounds, calvinsCaptains)
    val seasonTradeData = SeasonTradeData(playerStats, rounds)
    val finalSquadData = FinalSquadData(playerStats, rounds)
    val byeData = ByeData(playerStats, rounds, snapshot)
}
