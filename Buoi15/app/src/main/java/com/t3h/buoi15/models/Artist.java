package com.t3h.buoi15.models;

import com.t3h.basemodule.models.BaseModels;

public class Artist extends BaseModels {
    private String artist;
    private String number_of_album;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getNumber_of_album() {
        return number_of_album;
    }

    public void setNumber_of_album(String number_of_album) {
        this.number_of_album = number_of_album;
    }
}
