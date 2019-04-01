package com.sahar.countriesmvp.Screens.MainScreen;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.Toast;

import com.sahar.countriesmvp.Model.Country;
import com.sahar.countriesmvp.Model.Network.DataDownloader;
import com.sahar.countriesmvp.Model.Network.ImageDownloader;

import java.util.ArrayList;

public class MainPresenterImpl implements MainContract.MainPresenter {

    MainContract.MainView activity;
    ArrayList<Country> countryList ;

    DataDownloader dataDownloader ;
    public MainPresenterImpl(MainContract.MainView activity) {
        this.activity = activity ;
//        countryList = new ArrayList<Country>();

        dataDownloader = new DataDownloader(this);

     //   displayCountry(0);

    }

    @Override
    public void displayCountry(int position) {
        Country countryPos = countryList.get(position);
        activity.setCountryName(countryPos.getCountryName());
        activity.setCountryPop(countryPos.getPop());
        activity.setCountryRank(countryPos.getRank());

        ImageDownloader downloader = new ImageDownloader(this);
        downloader.execute(countryPos.getFlagUrl());

    }

    @Override
    public void setImage(Bitmap bitmap) {
        this.activity.setImage(bitmap);
    }

    @Override
    public void viewErrMsg() {
        Toast.makeText((Context) this.activity, "Downloading Failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setCountryList(ArrayList<Country> countryList) {
        Log.i("testing: ","countryList in MainP size is "+countryList.size());

        this.countryList = countryList ;
    }

    @Override
    public void displayFirstCountry() {
        //this.activity.displayFirstCountry(this.countryList.get(0));
    }


}
