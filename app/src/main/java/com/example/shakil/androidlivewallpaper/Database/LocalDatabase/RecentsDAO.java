package com.example.shakil.androidlivewallpaper.Database.LocalDatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.shakil.androidlivewallpaper.Database.Recents;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Shakil on 3/20/2018.
 */

@Dao
public interface RecentsDAO {
    @Query("SELECT * FROM recents ORDER BY saveTime DESC LIMIT 10")
    Flowable<List<Recents>> getAllRecents();

    @Insert
    void insertRecents(Recents... recents);

    @Update
    void updateRecents(Recents... recents);

    @Delete
    void deleteRecents(Recents... recents);

    @Query("DELETE FROM recents")
    void deleteAllRecents();

}
