package com.sahar.mofkrty.Screens.MainScreen;

import android.content.Context;

public interface MainContract {
    interface MainView{
        public String getUsername();
        public String getPassword();
    }
    interface MainPresenter{
        public boolean checkUser(String username,String password);
        public boolean regUser(String username,String password);


        public Context getContext();

        public void setLoggedInUser(String username);

        public String getLoggedInValue();
    }
}
