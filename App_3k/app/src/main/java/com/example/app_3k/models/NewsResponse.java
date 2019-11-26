package com.example.app_3k.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NewsResponse {
    @SerializedName("articles")
    private ArrayList<News> articles;

    public ArrayList<News> getArticles() {
        return articles;
    }

}
