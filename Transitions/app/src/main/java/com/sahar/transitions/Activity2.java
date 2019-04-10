package com.sahar.transitions;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Slide slide = new Slide(Gravity.TOP);
        getWindow().setEnterTransition(slide);
        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        TextView nameTV = findViewById(R.id.nameTVAct2);
        nameTV.setText(name);
    }
}
