package com.example.music.data;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import com.example.music.models.Album;
import com.example.music.models.Song;

import java.util.ArrayList;

public class AlbumData {
    private ContentResolver resolver;
    public AlbumData(Context context) {
        this.resolver = context.getContentResolver();
    }
    public ArrayList<Album> readData(){
        ArrayList<Album> arr = new ArrayList<>();

        Cursor cursor = resolver.query(
                MediaStore.Audio.Albums.INTERNAL_CONTENT_URI,
                null,
                null,
                null,
                null
        );
        cursor.moveToFirst();

        int indexALBUM = cursor.getColumnIndex(MediaStore.Audio.AlbumColumns.ALBUM);
        int indexARTIST = cursor.getColumnIndex(MediaStore.Audio.AlbumColumns.ARTIST);

        while (cursor.isAfterLast() == false){
            String album  = cursor.getString(indexALBUM);
            String artist  = cursor.getString(indexARTIST);

            Album album1 = new Album();
            album1.setAlbum(album);
            album1.setArtist(artist);
            arr.add(album1);
            cursor.moveToNext();
        }
        return arr;
    }
}
