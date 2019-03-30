package com.sahar.mofkrty.Screens.MainScreen;

import android.content.Context;

import com.sahar.mofkrty.Model.Database.SharedPrefOperImpl;
import com.sahar.mofkrty.Model.Database.SharedPrefOperations;

public class MainPresenterImpl implements MainContract.MainPresenter {

    MainContract.MainView activity ;
    SharedPrefOperations sharedPrefOperations ;

    public MainPresenterImpl(MainContract.MainView activity) {
        this.activity = activity ;
        this.sharedPrefOperations = new SharedPrefOperImpl(this);
    }

    @Override
    public boolean checkUser(String username, String password) {
        return this.sharedPrefOperations.checkUser(username, password);
    }

    @Override
    public boolean regUser(String username, String password) {
        return this.sharedPrefOperations.regUser(username, password);
    }

    @Override
    public Context getContext() {
        return (Context) activity;
    }

    @Override
    public void setLoggedInUser(String username) {
        this.sharedPrefOperations.setLoggedInUser(username);
    }

    @Override
    public String getLoggedInValue() {
        return this.sharedPrefOperations.getLoggedInValue();
    }
}
