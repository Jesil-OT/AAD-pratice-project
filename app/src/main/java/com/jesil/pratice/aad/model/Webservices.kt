package com.jesil.pratice.aad.model

import com.google.gson.GsonBuilder
import com.jesil.pratice.aad.utils.Utils.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Webservices {
    val retrofitWebservice: RetrofitService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(RetrofitService::class.java)
    }
}