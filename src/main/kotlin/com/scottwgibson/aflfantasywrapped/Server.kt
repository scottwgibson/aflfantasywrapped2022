package com.scottwgibson.aflfantasywrapped

import com.scottwgibson.aflfantasywrapped.aflfantasy.clients.AflFantasyClient
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.ClassicTeamRound
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.ShareLink
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.insights.CalvinsCaptainsData
import com.scottwgibson.aflfantasywrapped.models.WrappedData
import com.scottwgibson.aflfantasywrapped.templates.FantasyWrappedTemplate
import io.ktor.server.application.ApplicationCall
import io.ktor.server.html.respondHtmlTemplate
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import org.slf4j.LoggerFactory
import java.util.Base64

@OptIn(ExperimentalSerializationApi::class)
class Server(
    private val aflFantasyClient: AflFantasyClient,
    private val calvinsCaptainsData: CalvinsCaptainsData,
    private val shareUrl: String
) {
    private val logger = LoggerFactory.getLogger("Server")

    suspend fun extractUserIdFromShareLink(link: String): Int {
        return link.split("classic_team/")
            .last()
            .let {
                val sharelink: ShareLink = Json.decodeFromStream(Base64.getDecoder().decode(it).inputStream())
                if (sharelink.isAndroid()) {
                    sharelink.team_id
                } else {
                    aflFantasyClient.getClassicTeam(sharelink.team_id).userId
                }
            }
    }

    suspend fun showWrapupForUser(call: ApplicationCall, userId: Int) {
        val players = aflFantasyClient.getPlayers()
        val snapshot = aflFantasyClient.getClassicTeamSnapshot(userId)
        val rounds = getAllRounds(snapshot.id)

        // Create wrapped
        val wrapped = WrappedData(players, rounds, snapshot, calvinsCaptainsData)
        // Render
        call.respondHtmlTemplate(FantasyWrappedTemplate(wrapped, shareUrl)) {}
    }

    private suspend fun getAllRounds(teamId: Int): Map<Int, ClassicTeamRound> = coroutineScope {
        val rounds = (1..23).map {
            async(start = CoroutineStart.LAZY) {
                logger.info("$it")
                Pair(it, aflFantasyClient.getClassicTeam(teamId, it))
            }
        }

        rounds.awaitAll().associate { it }
    }
}
