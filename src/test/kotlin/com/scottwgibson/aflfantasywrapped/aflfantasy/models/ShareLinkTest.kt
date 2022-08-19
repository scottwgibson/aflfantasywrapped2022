package com.scottwgibson.aflfantasywrapped.aflfantasy.models

import io.ktor.util.decodeBase64String
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ShareLinkTest {
    @Test
    fun testAndroid() {
        val shareLink =
            "eyJjcyI6ImZiIiwidCI6MTY2MDg1MDU5NywidGVhbV9pZCI6MTc1ODQ4OX0="
                .decodeBase64String()

        val link = Json.decodeFromString<ShareLink>(shareLink)
        assertTrue(link.isAndroid())
        assertEquals(1758489, link.team_id)
    }

    @Test
    fun testIOS() {
        val shareLink =
            "eyJ0ZWFtX2lkIjoxMDE5MiwidCI6NjgyNjE0NzU2LCJzYyI6ImZiIn0="
                .decodeBase64String()

        val link = Json.decodeFromString<ShareLink>(shareLink)
        assertTrue(link.isIOS())
        assertEquals(10192, link.team_id)
    }
}
