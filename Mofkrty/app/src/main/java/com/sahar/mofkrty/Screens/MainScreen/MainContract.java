package com.sahar.mofkrty.Screens.MainScreen;

import android.content.Context;

import com.sahar.mofkrty.Screens.Presenter;

public interface MainContract {

    interface MainView{
        public String getUsername();
        public String getPassword();
    }

    interface MainPresenter extends Presenter {
        public boolean checkUser(String username,String password);
        public boolean regUser(String username,String password);
        public void setLoggedInUser(String username);
        public String getLoggedInValue();
    }
}
