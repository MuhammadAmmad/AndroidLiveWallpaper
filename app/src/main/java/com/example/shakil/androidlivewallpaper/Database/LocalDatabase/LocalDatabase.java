package com.example.shakil.androidlivewallpaper.Database.LocalDatabase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.shakil.androidlivewallpaper.Database.Recents;

import static com.example.shakil.androidlivewallpaper.Database.LocalDatabase.LocalDatabase.DATABASE_VERSION;

/**
 * Created by Shakil on 3/20/2018.
 */

@Database(entities = Recents.class, version = DATABASE_VERSION)
public abstract class LocalDatabase extends RoomDatabase {

    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "LiveWallpaper";

    public abstract RecentsDAO recentsDAO();

    public static LocalDatabase instance;

    public static LocalDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context, LocalDatabase.class, DATABASE_NAME).fallbackToDestructiveMigration().build();
        }
        return instance;
    }

}
