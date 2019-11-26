package com.example.btvn_buoi10_test.api;

import com.example.btvn_buoi10_test.model.NewResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("everything")
    Call<NewResponse> searchNews(
            @Query("q") String q,
            @Query("apikey") String apikey,
            @Query("language") String language
    );
}
