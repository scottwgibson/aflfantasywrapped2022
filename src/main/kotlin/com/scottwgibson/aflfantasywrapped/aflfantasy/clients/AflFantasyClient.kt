package com.scottwgibson.aflfantasywrapped.aflfantasy.clients

import com.scottwgibson.aflfantasywrapped.aflfantasy.models.ClassicTeamRound
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.ClassicTeamSnapshot
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.Player
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.accept
import io.ktor.client.request.cookie
import io.ktor.client.request.parameter
import io.ktor.client.request.request
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import java.time.Instant

class AflFantasyClient(
    private val client: HttpClient,
    private val baseUrl: String = "https://fantasy.afl.com.au"
) {

    private val sessionToken = "<token_here>"
    private val json = Json { ignoreUnknownKeys = true }

    @Serializable
    data class ResponseDTO<T>(
        val success: Int,
        val result: T,
        val errors: List<JsonElement>
    )

    suspend fun getPlayers(): Map<Int, Player> {
        return withContext(Dispatchers.IO) {
            val response = client.request("$baseUrl/data/afl/players.json") {
                method = HttpMethod.Get
            }

            response.body<List<Player>>().associateBy { it.id }
        }
    }

    suspend fun getClassicTeam(teamId: Int, round: Int? = null): ClassicTeamRound {
        val response =
            client.request("$baseUrl/afl_classic/api/teams_classic/show") {
                method = HttpMethod.Get
                parameter("id", teamId)
                round?.let { parameter("round", it) }
                parameter("_", Instant.now().toEpochMilli())
                cookie("session", sessionToken)
                accept(ContentType.parse("application/json"))
            }

        return response.body<ResponseDTO<ClassicTeamRound>>().result
    }

    suspend fun getClassicTeamSnapshot(userId: Int): ClassicTeamSnapshot {
        val response = client.request("$baseUrl/afl_classic/api/teams_classic/snapshot") {
            method = HttpMethod.Get
            parameter("user_id", userId)
            parameter("_", Instant.now().toEpochMilli())
            cookie("session", sessionToken)
        }

        return response.body<ResponseDTO<ClassicTeamSnapshot>>().result
    }
}
