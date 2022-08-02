package com.scottwgibson.aflfantasywrapped.aflfantasy

import com.scottwgibson.aflfantasywrapped.aflfantasy.models.Player
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream

object Util {
    val json = Json { ignoreUnknownKeys = true }

    val testPlayers = this::class.java.classLoader.getResource("players.json")?.openStream()?.let {
        json.decodeFromStream<List<Player>>(it)
    }
        ?.associateBy { it.id }
        .orEmpty()
}
