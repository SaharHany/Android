package com.sahar.layoutsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button frameBtn = findViewById(R.id.frameBtn);
        Button consBtn = findViewById(R.id.consBtn);
        Button gridBtn = findViewById(R.id.gridBtn);
        Button linearBtn = findViewById(R.id.linearBtn);
        Button relBtn = findViewById(R.id.relBtn);

        frameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FrameLayoutActivity.class);
                startActivity(intent);
            }
        });

        consBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ConstraintLayoutActivity.class);
                startActivity(intent);
            }
        });

        gridBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,GridLayoutActivity.class);
                startActivity(intent);
            }
        });

        linearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LinearLayoutActivity.class);
                startActivity(intent);
            }
        });


        relBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RelativeLayoutActivity.class);
                startActivity(intent);
            }
        });

    }
}
