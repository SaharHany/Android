package com.sahar.layoutsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class GridLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);
        ImageView imgV1 = findViewById(R.id.imgV1);
        imgV1.setImageResource(R.drawable.one);

        ImageView imgV2 = findViewById(R.id.imgV2);
        imgV2.setImageResource(R.drawable.two);

        ImageView imgV3 = findViewById(R.id.imgV3);
        imgV3.setImageResource(R.drawable.three);

        ImageView imgV4 = findViewById(R.id.imgV4);
        imgV4.setImageResource(R.drawable.four);

        ImageView imgV5 = findViewById(R.id.imgV5);
        imgV5.setImageResource(R.drawable.five);

        ImageView imgV6 = findViewById(R.id.imgV6);
        imgV6.setImageResource(R.drawable.six);

        ImageView imgV7 = findViewById(R.id.imgV7);
        imgV7.setImageResource(R.drawable.seven);

        ImageView imgV8 = findViewById(R.id.imgV8);
        imgV8.setImageResource(R.drawable.eight);

        ImageView imgV9 = findViewById(R.id.imgV9);
        imgV9.setImageResource(R.drawable.nine);

    }
}
