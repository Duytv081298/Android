package com.example.app_3k.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity

public class News {



    @ColumnInfo()       @SerializedName("title")                    private String title;
    @ColumnInfo()       @SerializedName("description")              private String description;
    @NonNull            @PrimaryKey()       @SerializedName("url")                      private String url;
    @ColumnInfo()       @SerializedName("urlToImage")               private String urlToImage;
    @ColumnInfo()       @SerializedName("publishedAt")              private String publishedAt;

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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }
}
