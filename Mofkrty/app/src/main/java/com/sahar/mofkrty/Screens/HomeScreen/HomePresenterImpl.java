package com.sahar.mofkrty.Screens.HomeScreen;

import android.content.Context;

import com.sahar.mofkrty.Model.Database.SharedPrefOperImpl;
import com.sahar.mofkrty.Model.Database.SharedPrefOperations;

public class HomePresenterImpl implements HomeContract.HomePresenter{

    HomeContract.HomeView activity ;
    SharedPrefOperations sharedPrefOperations ;

    public HomePresenterImpl(HomeContract.HomeView activity) {
        this.activity = activity ;
        this.sharedPrefOperations = new SharedPrefOperImpl(this);
    }

    @Override
    public Context getContext() {
        return (Context) activity;
    }

    @Override
    public void signOut() {
        this.sharedPrefOperations.signOut();
    }
}
