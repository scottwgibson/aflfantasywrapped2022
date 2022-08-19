package com.scottwgibson.aflfantasywrapped.aflfantasy.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ShareLink(
    @SerialName("team_id") val team_id: Int,
    val cs: String? = null,
    val sc: String? = null,
    val t: Int? = null
) {
    fun isAndroid() = cs?.isNotBlank() ?: false

    fun isIOS() = sc?.isNotBlank() ?: false
}
