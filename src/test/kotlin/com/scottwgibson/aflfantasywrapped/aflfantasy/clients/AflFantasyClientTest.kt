package com.scottwgibson.aflfantasywrapped.aflfantasy.clients

import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.call
import io.ktor.server.response.respondBytes
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import io.ktor.server.testing.testApplication
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.util.zip.GZIPOutputStream
import kotlin.test.assertEquals

@ExperimentalSerializationApi
class AflFantasyClientTest {

    private val playersJson = this::class.java.classLoader.getResource("players.json")
        ?.let {
            val bytes = this::class.java.classLoader.getResource("players.json")?.openStream()?.readAllBytes()
                ?: throw Exception()
            val out = ByteArrayOutputStream()
            val gzip = GZIPOutputStream(out)
            gzip.write(bytes)
            gzip.close()
            out.toByteArray()
        } ?: throw Exception("Couldn't load players.json")

    private val roundsJson = (1..20)
        .map { it.toString() }
        .associateWith {
            this::class.java.classLoader.getResource("rounds/$it.json")
                ?.openStream()
                ?.readAllBytes()
                ?.decodeToString()
        }

    private val snapshotJson = this::class.java.classLoader.getResource("snapshot.json")
        .openStream()
        ?.readAllBytes()
        ?.decodeToString() ?: throw Exception("Couldn't load snapshot.json")

    @Test
    fun testPlayerReceive() {
        testApplication {
            val client = createClient {
                install(ContentNegotiation) {
                    json(
                        Json {
                            ignoreUnknownKeys = true
                        }
                    )
                }
            }

            externalServices {
                hosts("https://testclient.com.au") {
                    routing {
                        get("/data/afl/players.json") {
                            call.respondBytes { playersJson }
                        }
                        get("/afl_classic/api/teams_classic/show") {
                            if (call.parameters["id"] == "10192") {
                                val round = call.parameters["round"] ?: roundsJson.keys.last()
                                roundsJson[round]
                                    ?.let { call.respondText(ContentType.parse("application/json")) { it } }
                            }
                        }
                        get("/afl_classic/api/teams_classic/snapshot") {
                            if (call.parameters["user_id"] == "1758489") {
                                call.respondText(ContentType.parse("application/json")) { snapshotJson }
                            }
                        }
                    }
                }
            }
            val aflClient = AflFantasyClient(client, "https://testclient.com.au")
            assertEquals(aflClient.getPlayers()[296205]?.firstName, "Jack")
            assertEquals(aflClient.getClassicTeam(10192).firstName, "Scott")
            assertEquals(aflClient.getClassicTeamSnapshot(1758489).lastName, "Gibson")
        }
    }
}
