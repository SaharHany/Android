package com.sahar.countriesmvp.Screens.MainScreen;

import android.graphics.Bitmap;

public interface MainContract {
    interface MainView{
        void setImage(Bitmap img);

        void setCountryRank(String countryRank);

        void setCountryName(String countryName);

        void setCountryPop(String countryPop);
    }

    interface MainPresenter{

    public void displayCountry(int position);
    }
}
