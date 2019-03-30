package com.sahar.mofkrty.Screens.HomeScreen;

import com.sahar.mofkrty.Screens.Presenter;

public interface HomeContract {
    interface HomeView{

    }

    interface HomePresenter extends Presenter {

        public void signOut();
    }

}
