package com.sahar.counterfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends AppCompatActivity implements Communicator{

    FragmentManager mgr;
    FragmentA fragA ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager mgr = getSupportFragmentManager();

        if(mgr.findFragmentByTag("fragA") !=null)
        {
            Log.i("testing mainactivity","inside if");
            fragA = (FragmentA) mgr.findFragmentByTag("fragA");
        }else {
            Log.i("testing mainactivity","inside else");

            fragA = new FragmentA();
            FragmentTransaction trns = mgr.beginTransaction();
            trns.add(R.id.frameLayoutFragA, fragA, "fragA");
            trns.commit();
        }
    }

    @Override
    public void increment() {

        FragmentB fragb = (FragmentB) getSupportFragmentManager().findFragmentById(R.id.fragment3);
        fragb.incrementCounter();
    }
}
