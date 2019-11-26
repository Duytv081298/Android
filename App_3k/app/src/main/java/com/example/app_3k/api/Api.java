package com.example.app_3k.api;

import com.example.app_3k.models.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("everything")
    Call<NewsResponse> searchNews(
            @Query("q") String q,
            @Query("apiKey") String apiKey,
            @Query("language") String lang
    );
}
