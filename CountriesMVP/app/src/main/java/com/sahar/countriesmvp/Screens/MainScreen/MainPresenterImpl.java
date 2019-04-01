package com.sahar.countriesmvp.Screens.MainScreen;

import android.graphics.Bitmap;

import com.sahar.countriesmvp.Model.Country;

import java.util.ArrayList;

public class MainPresenterImpl implements MainContract.MainPresenter {

    MainContract.MainView activity;
    ArrayList<Country> countryList ;

    public MainPresenterImpl(MainContract.MainView activity) {
        this.activity = activity ;
    }

    @Override
    public void displayCountry(int position) {
        //Bitmap img = ;
        //activity.setImage(img);
        Country countryPos = countryList.get(position);
        activity.setCountryName(countryPos.getCountryName());
        activity.setCountryPop(countryPos.getPop());
        activity.setCountryRank(countryPos.getRank());

    }

}
