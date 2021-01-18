package com.jesil.pratice.aad.data

import com.google.gson.annotations.SerializedName

data class SkillIqData(
    @SerializedName("name")
    var skillIqName: String,

    @SerializedName("score")
    var skillIqScore: Int,

    @SerializedName("country")
    var skillIqCountry: String,

    @SerializedName("badgeUrl")
    var SkillIqBadgeUrl: String
)
