package com.scottwgibson.aflfantasywrapped.aflfantasy.models

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@ExperimentalSerializationApi
@Serializable
data class Player(
    val id: Int,
    @SerialName("first_name") val firstName: String,
    @SerialName("last_name") val lastName: String,
    val cost: Int,
    @SerialName("squad_id") val squadId: Int
    // TODO: Finish player object
)

/*
{
    "id": 296205,
    "first_name": "Jack",
    "last_name": "Steele",
    "dob": "1995-12-13",
    "squad_id": 130,
    "cost": 930000,
    "status": "playing",
    "stats": {
    "prices": {
        "1": 1018000,
        "2": 1009000,
        "3": 989000,
        "4": 962000,
        "5": 955000,
        "6": 950000,
        "7": 944000,
        "8": 943000,
        "9": 929000,
        "10": 892000,
        "11": 892000,
        "12": 892000,
        "13": 892000,
        "14": 892000,
        "15": 892000,
        "16": 880000,
        "17": 877000,
        "18": 884000,
        "19": 894000,
        "20": 930000
    },
    "scores": {
        "1": 107,
        "2": 105,
        "3": 101,
        "4": 130,
        "5": 112,
        "6": 110,
        "7": 115,
        "8": 98,
        "9": 77,
        "15": 124,
        "16": 114,
        "17": 121,
        "18": 117,
        "19": 154
    },
    "ranks": {
        "1": 22,
        "2": 22,
        "3": 23,
        "4": 5,
        "5": 10,
        "6": 23,
        "7": 19,
        "8": 36,
        "9": 48,
        "15": 8,
        "16": 19,
        "17": 13,
        "18": 16,
        "19": 1
    },
    "season_rank": 3,
    "games_played": 14,
    "total_points": 1585,
    "avg_points": 113.2,
    "high_score": 154,
    "low_score": 77,
    "last_3_avg": 130.7,
    "last_5_avg": 126,
    "selections": 36888,
    "selections_info": {
        "c": 9.09,
        "vc": 5.82,
        "bc": 0.15,
        "emg": 0.05
    },
    "owned_by": 24.87,
    "adp": 1,
    "proj_avg": 122.8,
    "rd_tog": 92,
    "tog": 85,
    "career_avg": 97.1679,
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
