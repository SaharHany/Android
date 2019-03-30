package com.sahar.mofkrty.Screens.OptionsScreen;

import com.sahar.mofkrty.Screens.Presenter;

public interface OptionsContract {
    interface OptionsView{

    }
    interface OptionsPresenter extends Presenter {

        public boolean saveToFile(String username, String title, String body);

        public String loadFromFile(String username, String title);

        public boolean insertNote(String username, String title, String body);

        public String QueryNote(String username, String title);
    }
}
