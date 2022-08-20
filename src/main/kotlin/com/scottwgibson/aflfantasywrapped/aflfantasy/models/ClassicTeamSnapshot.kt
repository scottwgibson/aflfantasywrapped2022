package com.scottwgibson.aflfantasywrapped.aflfantasy.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ClassicTeamSnapshot(
    val id: Int,
    @SerialName("firstname") val firstName: String,
    @SerialName("lastname") val lastName: String,
    val name: String,
    val scoreflow: Map<String, Int>,
    @SerialName("league_scoreflow") val leagueScoreflow: Map<String, Int>,
    val points: Int,
    val rank: Int,
    @SerialName("round_rank") val roundRank: Int,
    @SerialName("rank_history") val rankHistory: Map<String, Int>,
    @SerialName("round_rank_history") val roundRankHistory: Map<String, Int>,
    @SerialName("num_teams") val numTeams: Int
)

/*
{
    "success":1,
    "result":{
    "id":1803,
    "firstname":"Matt",
    "lastname":"Mottram",
    "name":"Mottram's Marvels",
    "scoreflow":{
    "1":2001,
    "2":2212,
    "3":2128,
    "4":2152,
    "5":2195,
    "6":2186,
    "7":2419,
    "8":2104,
    "9":2283,
    "10":2334,
    "11":2360,
    "12":1916,
    "13":1732,
    "14":1838,
    "15":2327,
    "16":2388,
    "17":2378,
    "18":2343,
    "19":2500
},
    "points":41796,
    "round_rank":26,
    "rank":1,
    "league_scoreflow":{
    "1":2001,
    "2":2212,
    "3":2128,
    "4":2152,
    "5":2195,
    "6":2186,
    "7":2419,
    "8":2104,
    "9":2283,
    "10":2334,
    "11":2360,
    "12":1916,
    "13":1732,
    "14":1838,
    "15":2327,
    "16":2388,
    "17":2378,
    "18":2343,
    "19":2500
},
    "rank_history":{
    "1":14552,
    "2":3519,
    "3":1050,
    "4":669,
    "5":159,
    "6":94,
    "7":17,
    "8":13,
    "9":1,
    "10":1,
    "11":1,
    "12":1,
    "13":1,
    "14":1,
    "15":1,
    "16":1,
    "17":1,
    "18":1,
    "19":1
},
    "round_rank_history":{
    "1":14552,
    "2":2801,
    "3":1328,
    "4":7248,
    "5":237,
    "6":848,
    "7":29,
    "8":1361,
    "9":35,
    "10":58,
    "11":290,
    "12":1279,
    "13":11563,
    "14":1918,
    "15":735,
    "16":3179,
    "17":156,
    "18":5252,
    "19":26
},
    "num_teams":148360
},
    "errors":[

    ],
    "web_version":209
}
*/
