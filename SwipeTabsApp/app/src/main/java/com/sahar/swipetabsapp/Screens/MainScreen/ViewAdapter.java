package com.sahar.swipetabsapp.Screens.MainScreen;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import com.sahar.swipetabsapp.Screens.MainScreen.CalcScreen.CalcFragment;
import com.sahar.swipetabsapp.Screens.MainScreen.NumbersScreen.NumbersFragment;

public class ViewAdapter extends FragmentPagerAdapter {

    private static int NUM_FRAGS = 3 ;
    private String tabTitles[] = {"Calculator","Numbers","Shapes"};
    public ViewAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        return NUM_FRAGS;
    }



    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position)
        {
            case 0 :
                fragment = new CalcFragment();
                break;
            case 1 :
                fragment = new NumbersFragment();
                break;
            case 2 :
                fragment = new ShapesFragment();
                break;
        }
        return fragment ;

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
