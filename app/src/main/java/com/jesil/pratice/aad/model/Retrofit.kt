package com.jesil.pratice.aad.model

import com.jesil.pratice.aad.data.Learners
import com.jesil.pratice.aad.data.SkillIq
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("api/hours")
    fun getTopLearners(): Call<Learners>

    @GET("/api/skilliq")
    fun getSkillIq() : Call<SkillIq>
}

