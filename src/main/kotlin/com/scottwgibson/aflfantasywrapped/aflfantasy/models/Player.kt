package com.scottwgibson.aflfantasywrapped.aflfantasy.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlayerStats(
    val prices: Map<String, Int>,
    val scores: Map<String, Int>,
    val ranks: Map<String, Int>,
    @SerialName("season_rank") val seasonRank: Int,
    @SerialName("games_played") val gamesPlayed: Int,
    @SerialName("total_points") val totalPoints: Int,
    @SerialName("avg_points") val averagePoints: Float,
    @SerialName("high_score") val highScore: Int,
    @SerialName("low_score") val lowScore: Int,
    val selections: Int,
    @SerialName("owned_by") val ownedBy: Float,
    val adp: Int,
    @SerialName("proj_avg") val projectedAvg: Float,
    @SerialName("career_avg") val careerAvg: Float,
    val tog: Int,
    @SerialName("leagues_rostered") val leaguesRosteredPct: Float
)

@Serializable
data class Player(
    val id: Int,
    @SerialName("first_name") val firstName: String,
    @SerialName("last_name") val lastName: String,
    val cost: Int,
    @SerialName("squad_id") val squadId: Int,
    // TODO: Finish player object
    val dob: String,
    val stats: PlayerStats
)

/*
{

  "stats": {

    "selections_info": {
        "c": 9.09,
        "vc": 5.82,
        "bc": 0.15,
        "emg": 0.05
    },

    "season_rank": 3,
    "last_3_avg": 130.7,
    "last_5_avg": 126,
    "rd_tog": 92,
    "career_avg_vs": {
        "10": 85.3333,
        "20": 96.2,
        "30": 119.7143,
        "40": 97.7143,
        "50": 92.8,
        "60": 93.1,
        "70": 87.7778,
        "80": 105.875,
        "90": 92.6,
        "100": 106.8571,
        "110": 92,
        "120": 94.7,
        "130": 86,
        "140": 92.8333,
        "150": 103.125,
        "160": 109.75,
        "1000": 102.1429,
        "1010": 83.7143
    },
    "leagues_rostered": 99.5,
    "last_3_proj_avg": 104
},
    "stats_u18": "",
    "positions": [
    2
    ],
    "original_positions": [
    2
    ],
    "is_bye": 0,
    "locked": 0
}
*/
