package com.example.music.data;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import com.example.music.models.Artist;

import java.util.ArrayList;

public class ArtistData {
    private ContentResolver resolver;
    public ArtistData(Context context) {
        this.resolver = context.getContentResolver();
    }
    public ArrayList<Artist> readData(){
        ArrayList<Artist> arr = new ArrayList<>();

        Cursor cursor = resolver.query(
                MediaStore.Audio.Artists.INTERNAL_CONTENT_URI,
                null,
                null,
                null,
                null
        );
        cursor.moveToFirst();

        int indexARTIST = cursor.getColumnIndex(MediaStore.Audio.ArtistColumns.ARTIST);
        int indexNUMBER_OF_ALBUMS = cursor.getColumnIndex(MediaStore.Audio.ArtistColumns.NUMBER_OF_ALBUMS);

        while (cursor.isAfterLast() == false){
            String artist  = cursor.getString(indexARTIST);
            String number_of_album  = cursor.getString(indexNUMBER_OF_ALBUMS);
            Artist artist1 = new Artist();
            artist1.setArtist(artist);
            artist1.setNumber_of_album(number_of_album);
            arr.add(artist1);
            cursor.moveToNext();
        }
        return arr;
    }
}
