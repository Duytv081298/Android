package com.example.chatt3h.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiBuider {
    private static Api api;

    public static Api getInstance() {
        if (api == null) {
            api = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("http://192.168.1.136/chat1907e")
                    .build()
                    .create(Api.class);
        }
        return api;
    }




}
