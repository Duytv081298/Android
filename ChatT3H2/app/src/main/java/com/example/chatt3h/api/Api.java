package com.example.chatt3h.api;

import com.example.chatt3h.activity.register.RegisterActivity;
import com.example.chatt3h.model.Chat;
import com.example.chatt3h.model.User;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {
    @FormUrlEncoded
    @POST("/register.php")
    Call<ResponseBody> register(@Field("email") String email,
                                    @Field("password") String password,
                                    @Field("name") String name);

    @FormUrlEncoded
    @POST("/login.php")
    Call<User> Login(@Field("email") String email,
                     @Field("password") String password);

    @FormUrlEncoded
    @POST("/chat.php")
    Call<ResponseBody> chat(@Field("email") String email,
                            @Field("content") String content);

    @POST("/getchat.php")
    Call<List<Chat>> getChat();
}
