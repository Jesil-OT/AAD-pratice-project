package com.jesil.pratice.aad.model;

import com.jesil.pratice.aad.data.LearningLeadersData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("api/hours")
    Call<List<LearningLeadersData>> getPost();
}
