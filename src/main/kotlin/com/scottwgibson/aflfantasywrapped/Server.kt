package com.scottwgibson.aflfantasywrapped

import com.scottwgibson.aflfantasywrapped.aflfantasy.clients.AflFantasyClient
import com.scottwgibson.aflfantasywrapped.templates.Season2022WrappedTemplate
import io.ktor.server.application.ApplicationCall
import io.ktor.server.html.respondHtmlTemplate
import kotlinx.serialization.ExperimentalSerializationApi

@OptIn(ExperimentalSerializationApi::class)
class Server(
    private val aflFantasyClient: AflFantasyClient
) {

    suspend fun showWrapupForUser(call: ApplicationCall, teamId: Int) {
        val team = aflFantasyClient.getClassicTeam(teamId)
        val snapshot = aflFantasyClient.getClassicTeamSnapshot(team.userId)

        call.respondHtmlTemplate(Season2022WrappedTemplate(snapshot.name, team.lineup.starting22())) {}
    }
}
