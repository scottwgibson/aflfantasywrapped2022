package com.scottwgibson.aflfantasywrapped.aflfantasy.models.insights

import com.scottwgibson.aflfantasywrapped.aflfantasy.models.Player
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.roundScore

data class RoundCaptains(
    val round: Int,
    val captain: Player,
    val viceCaptain: Player
) {
    fun loopholeUsed(): Boolean = captain.roundScore(round) == null && viceCaptain.roundScore(round) != null

    fun finalCaptainScore(): Int = captain.roundScore(round) ?: viceCaptain.roundScore(round) ?: 0

    fun finalCaptain(): Player = if (loopholeUsed()) viceCaptain else captain
}
