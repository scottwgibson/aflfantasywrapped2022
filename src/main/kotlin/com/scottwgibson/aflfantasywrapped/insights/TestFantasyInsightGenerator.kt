package com.scottwgibson.aflfantasywrapped.insights

import com.scottwgibson.aflfantasywrapped.aflfantasy.models.ClassicTeamRound
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.ClassicTeamSnapshot
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.Player
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.PlayerId
import kotlinx.serialization.ExperimentalSerializationApi

@OptIn(ExperimentalSerializationApi::class)
class TestFantasyInsight(
    private val playerInfo: Map<PlayerId, Player>,
    private val teamSnapshot: ClassicTeamSnapshot,
    private val teamRounds: Map<Int, ClassicTeamRound>
) : AbstractFantasyInsight {

}
