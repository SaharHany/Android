package com.sahar.layoutsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RelativeLayoutActivity extends AppCompatActivity {

    EditText nameET ;
    Button showBtn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);
        nameET = findViewById(R.id.nameET);
        showBtn = findViewById(R.id.showBtn);
        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameET.getText().toString();
                nameET.setText("");
                Toast.makeText(RelativeLayoutActivity.this, "Your name is : "+name, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
