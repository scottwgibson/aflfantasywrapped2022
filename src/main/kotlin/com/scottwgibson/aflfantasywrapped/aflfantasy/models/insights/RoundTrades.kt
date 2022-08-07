package com.scottwgibson.aflfantasywrapped.aflfantasy.models.insights

import com.scottwgibson.aflfantasywrapped.aflfantasy.models.Player

data class RoundTrades(
    val round: Int,
    val tradeOut: List<Player>,
    val tradeIn: List<Player>
)
