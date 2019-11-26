package com.example.test_app_3k.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NewResponse {
    @SerializedName("articles")
    private ArrayList<News> articles;

    public ArrayList<News> getArticles() {
        return articles;
    }
}
