package com.scottwgibson.aflfantasywrapped.aflfantasy.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

typealias PlayerId = Int

@Serializable
data class Bench(
    @SerialName("1") val defenders: Set<PlayerId> = emptySet(),
    @SerialName("2") val midfielders: Set<PlayerId> = emptySet(),
    @SerialName("3") val rucks: Set<PlayerId> = emptySet(),
    @SerialName("4") val forwards: Set<PlayerId> = emptySet(),
    val emergency: Set<PlayerId> = emptySet()
)

@Serializable
data class Lineup(
    val captain: PlayerId,
    @SerialName("vice_captain") val viceCaptain: PlayerId,
    @SerialName("1") val defenders: Set<PlayerId> = emptySet(),
    @SerialName("2") val midfielders: Set<PlayerId> = emptySet(),
    @SerialName("3") val rucks: Set<PlayerId> = emptySet(),
    @SerialName("4") val forwards: Set<PlayerId> = emptySet(),
    val bench: Bench = Bench()
) {
    fun starting22() = defenders + midfielders + rucks + forwards
}
