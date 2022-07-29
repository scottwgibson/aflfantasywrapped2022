package com.scottwgibson.aflfantasywrapped.aflfantasy.clients

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.HttpHeaders.ContentEncoding
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import org.junit.Test

@OptIn(ExperimentalSerializationApi::class)
class AflFantasyClientTest {

    val httpClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                }
            )
        }
        install(ContentEncoding) {
            // gzip()
        }

        install(HttpCache)
    }

    @Test
    fun devPlayersTest() = runBlocking {
        val client = AflFantasyClient(
            httpClient
        )
        println(client.getPlayers().values.first())
    }

    @Test
    fun devClassicTeamRoundTest() = runBlocking {
        val client = AflFantasyClient(
            httpClient
        )
        val response = client.getClassicTeam(1803)
        println(response)
    }

    @Test
    fun devClassicTeamSnapshotTest() = runBlocking {
        val client = AflFantasyClient(
            httpClient
        )
        val response = client.getClassicTeamSnapshot(1922154)
        println(response)
    }
}
