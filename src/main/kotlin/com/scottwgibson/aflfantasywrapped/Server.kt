package com.scottwgibson.aflfantasywrapped

import com.scottwgibson.aflfantasywrapped.aflfantasy.clients.AflFantasyClient
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.ClassicTeamRound
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.insights.SeasonCaptainData
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.insights.SeasonTradeData
import com.scottwgibson.aflfantasywrapped.services.FantasyWrappedService
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
    suspend fun showWrapupForUser(call: ApplicationCall, teamId: Int) {
        val players = aflFantasyClient.getPlayers()
        val team = aflFantasyClient.getClassicTeam(teamId)
        val rounds = getAllRounds(teamId)
        val snapshot = aflFantasyClient.getClassicTeamSnapshot(team.userId)

        rounds.values.forEachIndexed { i, it ->
            val captain = players[it.lineup.captain]
            println("${i + 1}: ${captain?.firstName} ${captain?.lastName}")
        }

        val loophole = SeasonCaptainData(players, rounds)
        println("*****")
        println("Team name: ${team.name}")
        println("Times loophole used: ${loophole.timesLoopholeUsed()}")
        loophole.roundCaptains.values.filter { it.loopholeUsed() }
            .forEach { println("Round ${it.round}: ${it.viceCaptain.lastName} looped by ${it.captain.lastName}") }

        val tradeData = SeasonTradeData(players, rounds)
        // Create wrapped
        val wrapped = FantasyWrappedService.createWrapped(players, rounds, snapshot)
        // Render
        call.respondHtmlTemplate(FantasyWrappedTemplate(wrapped)) {}
    }

    private suspend fun getAllRounds(teamId: Int): Map<Int, ClassicTeamRound> = coroutineScope {
        val rounds = (1..21).map {
            async(start = CoroutineStart.LAZY) {
                logger.info("$it")
                Pair(it, aflFantasyClient.getClassicTeam(teamId, it))
            }
        }

        rounds.awaitAll().associate { it }
    }
}
