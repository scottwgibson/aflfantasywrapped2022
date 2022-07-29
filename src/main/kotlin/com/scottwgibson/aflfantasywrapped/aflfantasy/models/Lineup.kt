package com.scottwgibson.aflfantasywrapped.aflfantasy.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

typealias PlayerId = Int

@Serializable
data class Bench(
    @SerialName("1") val defenders: Set<PlayerId>,
    @SerialName("2") val midfielders: Set<PlayerId>,
    @SerialName("3") val rucks: Set<PlayerId>,
    @SerialName("4") val forwards: Set<PlayerId>,
    val emergency: Set<PlayerId>
)

@Serializable
data class Lineup(
    val captain: PlayerId,
    @SerialName("vice_captain") val viceCaptain: PlayerId,
    @SerialName("1") val defenders: Set<PlayerId>,
    @SerialName("2") val midfielders: Set<PlayerId>,
    @SerialName("3") val rucks: Set<PlayerId>,
    @SerialName("4") val forwards: Set<PlayerId>,
    val bench: Bench
)
