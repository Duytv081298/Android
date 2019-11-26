package com.example.btvn_buoi10_test.model;

import com.google.gson.annotations.SerializedName;

public class News  {
    @SerializedName("title")                    private String title;
    @SerializedName("description")              private String description;
    @SerializedName("url")                      private String url;
    @SerializedName("urlToImage")               private String urlToImage;
    @SerializedName("publishedAt")              private String publishedAt;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }
}