package com.example.shakil.androidlivewallpaper.Database.DataSource;

import com.example.shakil.androidlivewallpaper.Database.Recents;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Shakil on 3/20/2018.
 */

public interface IRecentsDataSource {
    Flowable<List<Recents>> getAllRecents();
    void insertRecents(Recents... recents);
    void updateRecents(Recents... recents);
    void deleteRecents(Recents... recents);
    void deleteAllRecents();


}
