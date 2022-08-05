package com.scottwgibson.aflfantasywrapped.aflfantasy.models.insights

import com.scottwgibson.aflfantasywrapped.aflfantasy.models.Player
import com.scottwgibson.aflfantasywrapped.aflfantasy.models.PlayerStats
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Players are referred to as C (captain) or VC (vice captain)
 */
class RoundCaptainsTest {

    @Test
    fun `should return C's data when there is a playing VC and C`() {
        val playerCStats = mock<PlayerStats> {
            on { scores } doReturn (mapOf("1" to 100))
        }
        val testC = mock<Player> {
            on { stats } doReturn (playerCStats)
        }

        val playerVCStats = mock<PlayerStats> {
            on { scores } doReturn (mapOf("1" to 90))
        }
        val testVC = mock<Player> {
            on { stats } doReturn (playerVCStats)
        }

        val data = RoundCaptains(1, testC, testVC)
        assertFalse(data.loopholeUsed())
        assertEquals(100, data.finalCaptainScore())
        assertEquals(testC, data.finalCaptain())
    }

    @Test
    fun `should return VC's data with a playing VC and non-playing C`() {
        val playerCStats = mock<PlayerStats> {
            on { scores } doReturn (mapOf())
        }
        val testC = mock<Player>() {
            on { stats } doReturn (playerCStats)
        }

        val playerVCStats = mock<PlayerStats> {
            on { scores } doReturn (mapOf("1" to 90))
        }
        val testVC = mock<Player>() {
            on { stats } doReturn (playerVCStats)
        }

        val data = RoundCaptains(1, testC, testVC)
        assertTrue(data.loopholeUsed())
        assertEquals(90, data.finalCaptainScore())
        assertEquals(testVC, data.finalCaptain())
    }

    @Test
    fun `should return C's data with both non playing VC and C`() {
        val playerCStats = mock<PlayerStats> {
            on { scores } doReturn (mapOf("2" to 100))
        }
        val testC = mock<Player>() {
            on { stats } doReturn (playerCStats)
        }

        val playerVCStats = mock<PlayerStats> {
            on { scores } doReturn (mapOf("2" to 90))
        }
        val testVC = mock<Player>() {
            on { stats } doReturn (playerVCStats)
        }

        val data = RoundCaptains(1, testC, testVC)
        assertFalse(data.loopholeUsed())
        assertEquals(0, data.finalCaptainScore())
        assertEquals(testC, data.finalCaptain())
    }
}
