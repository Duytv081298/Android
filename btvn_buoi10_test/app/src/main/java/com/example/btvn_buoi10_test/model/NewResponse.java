package com.example.btvn_buoi10_test.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NewResponse {
    @SerializedName("articles")
    private ArrayList<News> articles;

    public ArrayList<News> getArticles() {
        return articles;
    }
}
