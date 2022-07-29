package com.scottwgibson.aflfantasywrapped.aflfantasy.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ClassicTeamRound(
    val id: Int,
    @SerialName("user_id") val userId: Int,
    val name: String,
    val points: Int,
    val complete: Int,
    val valid: Int,
    @SerialName("salary_cap") val salaryCap: Int,
    val value: Int,
    @SerialName("firstname") val firstName: String,
    @SerialName("lastname") val lastName: String,
    val lineup: Lineup,
    val scoreflow: Map<Int, Int>
)
/*
{
    "success":1,
    "result":{
    "id":1803,
    "user_id":1922154,
    "name":"Mottram's Marvels",
    "points":41796,
    "lineup":{
        "1":[
        295518,
        994389,
        992242,
        992049,
        293871,
        297566
        ],
        "2":[
        293222,
        1002232,
        298272,
        296205,
        993905,
        992016,
        295467,
        293535
        ],
        "3":[
        290528,
        1007591
        ],
        "4":[
        291969,
        297373,
        1004592,
        993834,
        290778,
        998172
        ],
        "bench":{
        "1":[
        1004530,
        993836
        ],
        "2":[
        1020802,
        1023272,
        296280
        ],
        "3":[
        998145
        ],
        "4":[
        1027021,
        1017043
        ],
        "emergency":[
        1027021,
        1004530,
        1020802,
        998145
        ]
    },
        "captain":1007591,
        "vice_captain":293222
    },
    "formation":"6-8-2-6\/2-3-1-2",
    "complete":1,
    "valid":1,
    "complete_first_time":1,
    "salary_cap":20899000,
    "value":20646000,
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
    "start_round":1,
    "activated_at":"2022-03-16T18:43:18+11:00",
    "firstname":"Matt",
    "lastname":"Mottram"
},
    "errors":[

    ],
    "web_version":209
}
*/
