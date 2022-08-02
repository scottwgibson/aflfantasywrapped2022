package com.scottwgibson.aflfantasywrapped.aflfantasy.models.insights

import com.scottwgibson.aflfantasywrapped.aflfantasy.Util.testPlayers
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.Bench
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.ClassicTeamRound
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.Lineup
import kotlin.test.Test
import kotlin.test.assertEquals

internal class PopularCaptainsInsightTest {

    @Test
    fun testCaptainInsight() {
        // Occurrences to player Id
        val rounds = listOf(
            1 to 298210,
            5 to 296205,
            4 to 298272,
            3 to 291856,
            2 to 295467,
            1 to 996701
        )
            .flatMap { generateSequence { it.second }.take(it.first) }
            .map {
                ClassicTeamRound(
                    id = 1,
                    userId = 1,
                    name = "Test",
                    points = 0,
                    complete = 1,
                    valid = 1,
                    firstName = "Test",
                    lastName = "User",
                    salaryCap = 15_000_000,
                    value = 14_000_000,
                    scoreflow = emptyMap(),
                    lineup = Lineup(
                        captain = it,
                        viceCaptain = 0,
                        defenders = emptySet(),
                        midfielders = emptySet(),
                        rucks = emptySet(),
                        forwards = emptySet(),
                        bench = Bench(
                            defenders = emptySet(),
                            midfielders = emptySet(),
                            rucks = emptySet(),
                            forwards = emptySet(),
                            emergency = emptySet()
                        )
                    )
                )
            }
            .mapIndexed { i, it -> i to it }.toMap()

        val result = PopularCaptainsInsight(testPlayers, rounds)
        val expected = listOf(
            testPlayers[296205] to 5,
            testPlayers[298272] to 4,
            testPlayers[291856] to 3,
            testPlayers[295467] to 2,
            testPlayers[298210] to 1
        )
        assertEquals(expected, result.captains)
    }
}
