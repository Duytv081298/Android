package com.android.buoi10.api;

import com.android.buoi10.model.NewResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("everything")
    Call<NewResponse> searchNews(
            @Query("q") String q,
            @Query("apikey") String apikey ,
            @Query("language") String language
            );
}
