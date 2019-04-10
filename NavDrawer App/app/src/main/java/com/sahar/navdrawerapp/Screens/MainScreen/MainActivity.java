package com.sahar.navdrawerapp.Screens.MainScreen;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;

import com.sahar.navdrawerapp.Model.Place;
import com.sahar.navdrawerapp.R;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout ;
    Toolbar toolbar ;
    NavigationView navigationView ;

    RecyclerView recyclerView ;
    RecyclerView.Adapter recyclerViewAdapter ;
    RecyclerView.LayoutManager recyclerViewLayoutManager ;
    Place[] myData = {new Place("Giza",R.drawable.giza)
            ,new Place("Dubai",R.drawable.dubai)
            ,new Place("Paris",R.drawable.paris)
            ,new Place("TajMahl",R.drawable.tajmahl)
            ,new Place("Toronto",R.drawable.toronto)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();

        //setting linear layout manager
        this.recyclerView = findViewById(R.id.recyclerView);
        this.recyclerViewLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);

        //setting adapter
        recyclerViewAdapter = new Adapter(myData);
        recyclerView.setAdapter(recyclerViewAdapter);

    }

    private void initComponents() {
        drawerLayout = findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navView);
        setSupportActionBar(toolbar);
        setMenu();
        setListeners();
    }

    private void setListeners() {


    }

    private void setMenu() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.icon);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true ;
        }

        return super.onOptionsItemSelected(item);
    }
}
