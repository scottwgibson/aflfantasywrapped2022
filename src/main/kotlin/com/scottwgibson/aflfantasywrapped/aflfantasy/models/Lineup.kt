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
) {
    fun toSet(): Set<PlayerId> = defenders + midfielders + rucks + forwards
}

@Serializable
data class Lineup(
    val captain: PlayerId? = null,
    @SerialName("vice_captain") val viceCaptain: PlayerId? = null,
    @SerialName("1") val defenders: Set<PlayerId> = emptySet(),
    @SerialName("2") val midfielders: Set<PlayerId> = emptySet(),
    @SerialName("3") val rucks: Set<PlayerId> = emptySet(),
    @SerialName("4") val forwards: Set<PlayerId> = emptySet(),
    val bench: Bench = Bench()
) {
    fun starting22(): Set<PlayerId> = defenders + midfielders + rucks + forwards

    fun toSet(): Set<PlayerId> = starting22() + bench.toSet()
}
