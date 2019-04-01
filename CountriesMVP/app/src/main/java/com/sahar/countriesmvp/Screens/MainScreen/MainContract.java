package com.sahar.countriesmvp.Screens.MainScreen;

import android.content.Context;
import android.graphics.Bitmap;

import com.sahar.countriesmvp.Model.Country;

import java.util.ArrayList;

public interface MainContract {
    interface MainView{
        void setImage(Bitmap img);

        void setCountryRank(String countryRank);

        void setCountryName(String countryName);

        void setCountryPop(String countryPop);

        void displayFirstCountry(Country country);
    }

    interface MainPresenter{

    public void displayCountry(int position);

        void setImage(Bitmap bitmap);

        void viewErrMsg();

        void setCountryList(ArrayList<Country> countryList);
        
        void displayFirstCountry();
    }
}
