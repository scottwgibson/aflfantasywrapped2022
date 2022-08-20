package com.scottwgibson.aflfantasywrapped.aflfantasy.models.insights

import com.scottwgibson.aflfantasywrapped.aflfantasy.models.ClassicTeamRound
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.Lineup
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.Player
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.PlayerStats
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import kotlin.test.assertEquals

class SeasonCaptainDataTest {

    private val mockPlayers = mapOf(
        1 to mockPlayer(1, listOf(100, 90, 80).toRoundScores()),
        2 to mockPlayer(2, listOf(10, 20, 30).toRoundScores()),
        3 to mockPlayer(3, listOf(null, 30, 100).toRoundScores()),
        4 to mockPlayer(4, listOf(null, null, 100).toRoundScores())
    )

    private val calvinsCaptainsData = CalvinsCaptainsData(
        mapOf(
            "1" to listOf(1, 2, 3),
            "2" to listOf(4, 5, 1),
            "3" to listOf(4, 5, 6)
        )
    )

    @Test
    fun `test average captain and ordered captain score`() {
        val rounds = listOf(
            Lineup(1, 2),
            Lineup(1, 3),
            Lineup(2, 3)
        ).toClassicRounds()

        val data = SeasonCaptainData(mockPlayers, rounds, calvinsCaptainsData)

        assertEquals(listOf(100, 90, 30).average(), data.averageCaptainScore())
        assertEquals(
            listOf(100, 90, 30),
            data.orderedByScoreDesc().map { it.finalCaptainScore() }
        )
    }

    @Test
    fun `test calvins captains calculation`() {
        val rounds = listOf(
            Lineup(1, 2),
            Lineup(1, 2),
            Lineup(1, 2)
        ).toClassicRounds()

        val data = SeasonCaptainData(mockPlayers, rounds, calvinsCaptainsData)
        assertEquals(2, data.timesUsingCalvinsTop3())
    }

    @Test
    fun `test loophole count`() {
        val rounds = listOf(
            Lineup(3, 1),
            Lineup(4, 1),
            Lineup(1, 3)
        )
            .toClassicRounds()

        val data = SeasonCaptainData(mockPlayers, rounds, calvinsCaptainsData)
        assertEquals(2, data.timesLoopholeUsed())
    }

    private fun List<Lineup>.toClassicRounds() = this.map { lineup ->
        mock<ClassicTeamRound> {
            on { it.lineup } doReturn (lineup)
        }
    }
        .mapIndexed { i, it -> i.plus(1) to it }
        .toMap()

    private fun List<Int?>.toRoundScores(): Map<String, Int> =
        this.mapIndexed { i, it -> i + 1 to it }
            .mapNotNull { scorePair ->
                val (round, score) = scorePair
                score?.let { round.toString() to it }
            }
            .toMap()

    private fun mockPlayer(id: Int, roundScores: Map<String, Int>): Player {
        val playerStats = mock<PlayerStats> {
            on { it.scores }.thenReturn(roundScores)
        }

        return mock {
            on { it.id }.thenReturn(id)
            on { it.stats }.thenReturn(playerStats)
        }
    }
}
