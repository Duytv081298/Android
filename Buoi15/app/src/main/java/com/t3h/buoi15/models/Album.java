package com.t3h.buoi15.models;

import com.t3h.basemodule.models.BaseModels;

public class Album extends BaseModels {
    private String album;
    private String artist;



    public void setAlbum(String album) {
        this.album = album;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public String getArtist() {
        return artist;
    }
}
