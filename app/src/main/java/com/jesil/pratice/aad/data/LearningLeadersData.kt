package com.jesil.pratice.aad.data

import com.google.gson.annotations.SerializedName

data class LearningLeadersData(
    @SerializedName("name")
    var learningLeadersName: String,

    @SerializedName("hours")
    var learningLeadersHours: Int,

    @SerializedName("country")
    var learningLeadersCountry: String,

    @SerializedName("badgeUrl")
    var learningLeadersBadgeUrl: String
) {

}