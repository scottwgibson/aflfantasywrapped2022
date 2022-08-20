package com.scottwgibson.aflfantasywrapped.aflfantasy.models.insights

import com.scottwgibson.aflfantasywrapped.aflfantasy.models.PlayerId
import kotlinx.serialization.Serializable

@Serializable
class CalvinsCaptainsData(
    val rounds: Map<String, List<PlayerId>>
)
