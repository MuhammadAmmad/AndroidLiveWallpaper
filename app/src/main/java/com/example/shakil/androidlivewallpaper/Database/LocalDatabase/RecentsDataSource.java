package com.example.shakil.androidlivewallpaper.Database.LocalDatabase;

import com.example.shakil.androidlivewallpaper.Database.DataSource.IRecentsDataSource;
import com.example.shakil.androidlivewallpaper.Database.Recents;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Shakil on 3/20/2018.
 */

public class RecentsDataSource implements IRecentsDataSource {

    private RecentsDAO recentsDAO;
    private static RecentsDataSource instance;

    public RecentsDataSource(RecentsDAO recentsDAO) {
        this.recentsDAO = recentsDAO;
    }

    public static RecentsDataSource getInstance(RecentsDAO recentsDAO){
        if (instance == null){
            instance = new RecentsDataSource(recentsDAO);
        }
        return instance;
    }

    @Override
    public Flowable<List<Recents>> getAllRecents() {
        return recentsDAO.getAllRecents();
    }

    @Override
    public void insertRecents(Recents... recents) {
        recentsDAO.insertRecents(recents);
    }

    @Override
    public void updateRecents(Recents... recents) {
        recentsDAO.updateRecents(recents);
    }

    @Override
    public void deleteRecents(Recents... recents) {
        recentsDAO.deleteRecents(recents);
    }

    @Override
    public void deleteAllRecents() {
        recentsDAO.deleteAllRecents();
    }
}
