package com.example.app_3k.dao;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.app_3k.models.News;

@Database(entities = {News.class}, version = 1)
// entities
// version
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;

    public static AppDatabase getInstance(Context context) {
        if(instance == null){
            instance = Room.databaseBuilder(context
            ,AppDatabase.class
            ,"Filter News")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    public abstract NewsDao getNewsDao();
}
