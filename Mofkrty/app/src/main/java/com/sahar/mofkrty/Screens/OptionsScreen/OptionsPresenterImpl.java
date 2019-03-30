package com.sahar.mofkrty.Screens.OptionsScreen;

import android.content.Context;

import com.sahar.mofkrty.Model.Database.DatabaseAdapter;
import com.sahar.mofkrty.Model.Database.DatabaseOperImpl;
import com.sahar.mofkrty.Model.Database.DatabaseOperations;

public class OptionsPresenterImpl implements OptionsContract.OptionsPresenter {
    OptionsContract.OptionsView activity ;
    DatabaseOperations databaseOperations ;
    DatabaseAdapter dbAdapter = null;


    public OptionsPresenterImpl(OptionsContract.OptionsView activity) {
        this.activity = activity ;
        this.databaseOperations = new DatabaseOperImpl(this);
        dbAdapter = new DatabaseAdapter(getContext());

    }

    @Override
    public Context getContext() {
        return (Context) activity;
    }

    @Override
    public boolean saveToFile(String username, String title, String body) {
        return this.databaseOperations.saveToFile(username, title, body);
    }

    @Override
    public String loadFromFile(String username, String title) {
        return this.databaseOperations.loadFromFile(username, title);
    }

    @Override
    public boolean insertNote(String username, String title, String body) {

        return dbAdapter.insertNote(username,title,body);

    }

    @Override
    public String QueryNote(String username, String title) {
        return dbAdapter.QueryNote(username,title);
    }
}
