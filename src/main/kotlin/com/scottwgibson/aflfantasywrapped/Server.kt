package com.scottwgibson.aflfantasywrapped

import com.scottwgibson.aflfantasywrapped.aflfantasy.clients.AflFantasyClient
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.ClassicTeamRound
import com.scottwgibson.aflfantasywrapped.services.WrappedData
import com.scottwgibson.aflfantasywrapped.templates.FantasyWrappedTemplate
import io.ktor.server.application.ApplicationCall
import io.ktor.server.html.respondHtmlTemplate
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.serialization.ExperimentalSerializationApi
import org.slf4j.LoggerFactory

@OptIn(ExperimentalSerializationApi::class)
class Server(
    private val aflFantasyClient: AflFantasyClient
) {

    private val logger = LoggerFactory.getLogger("Server")

    suspend fun showWrapupForTeam(call: ApplicationCall, teamId: Int) {
        val players = aflFantasyClient.getPlayers()
        val team = aflFantasyClient.getClassicTeam(teamId)
        val rounds = getAllRounds(teamId)
        val snapshot = aflFantasyClient.getClassicTeamSnapshot(team.userId)

        // Create wrapped
        val wrapped = WrappedData(players, rounds, snapshot)
        // Render
        call.respondHtmlTemplate(FantasyWrappedTemplate(wrapped)) {}
    }

    suspend fun showWrapupForUser(call: ApplicationCall, userId: Int) {
        val players = aflFantasyClient.getPlayers()
        val snapshot = aflFantasyClient.getClassicTeamSnapshot(userId)
        val rounds = getAllRounds(snapshot.id)

        // Create wrapped
        val wrapped = WrappedData(players, rounds, snapshot)
        // Render
        call.respondHtmlTemplate(FantasyWrappedTemplate(wrapped)) {}
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
