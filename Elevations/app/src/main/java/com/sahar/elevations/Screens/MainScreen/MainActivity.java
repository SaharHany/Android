package com.sahar.elevations.Screens.MainScreen;

import android.animation.ObjectAnimator;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.sahar.elevations.Model.Place;
import com.sahar.elevations.R;

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

    FloatingActionButton fab ;
    Animation scale ;
    ObjectAnimator fabAnimation ;
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
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.drawable.rowripple);
            }
        });


    fab = findViewById(R.id.fab);
    scale = AnimationUtils.loadAnimation(this,R.anim.fabraise);
    fabAnimation = ObjectAnimator.ofFloat(fab,"x",-100);
    fabAnimation.setRepeatCount(1);
    fabAnimation.setRepeatMode(ObjectAnimator.REVERSE);
    fabAnimation.setDuration(2000);

    fab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            fab.startAnimation(scale);
            fabAnimation.start();
        }
    });

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
