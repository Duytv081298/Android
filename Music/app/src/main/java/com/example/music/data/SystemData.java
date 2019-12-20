package com.example.music.data;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import com.example.music.models.Song;

import java.util.ArrayList;

public class SystemData {
    private ContentResolver resolver;
    public SystemData(Context context) {
        this.resolver = context.getContentResolver();
    }
    public ArrayList<Song> readData(){
        ArrayList<Song> arr = new ArrayList<>();

        Cursor cursor = resolver.query(
                MediaStore.Audio.Media.INTERNAL_CONTENT_URI,
                null,
                null,
                null,
                null
        );
        cursor.moveToFirst();

        //        while (cursor.isAfterLast() == false){ // chưa phải cuối cùng
//            String[]  columns = cursor.getColumnNames();
//        for (int i = 0; i < columns.length ; i++) {
//            Log.e(columns[i], cursor.getString(i) +"");
//        }
//            Log.e("===================", "========================");
//            cursor.moveToNext();}

        int indexDATA = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.DATA);
        int indexTITLE = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.TITLE);
        int indexDURATION = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.DURATION);
        int indexSIZE = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.SIZE);
        int indexARTIST = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.ARTIST);
        int indexALBUM = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.ALBUM);

        while (cursor.isAfterLast() == false){
            String data  = cursor.getString(indexDATA);
            String title  = cursor.getString(indexTITLE);
            int duration  = cursor.getInt(indexDURATION);
            int size  = cursor.getInt(indexSIZE);
            String artist  = cursor.getString(indexARTIST);
            String album  = cursor.getString(indexALBUM);
            Song song = new Song();
            song.setData(data);;
            song.setTitle(title);
            song.setDuration(duration);
            song.setSize(size);
            song.setArtist(artist);
            song.setAlbum(album);
            arr.add(song);
            cursor.moveToNext();
        }
        return arr;
    }
}
