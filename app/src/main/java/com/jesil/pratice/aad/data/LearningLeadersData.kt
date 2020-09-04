package com.jesil.pratice.aad.data

import com.google.gson.annotations.SerializedName

class LearningLeadersData(
    @SerializedName("name")
    var learningLeadersName: String,

    @SerializedName("hours")
    var learningLeadersHours: String,

    @SerializedName("country")
    var learningLeadersCountry: String,

    @SerializedName("badgeUrl")
    var learningLeadersBadgeUrl : String
){

}