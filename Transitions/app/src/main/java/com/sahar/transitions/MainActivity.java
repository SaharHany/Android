package com.sahar.transitions;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText nameET ;
    Button showBtn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameET = findViewById(R.id.nameET);
        showBtn = findViewById(R.id.showBtn);

    }

    @Override
    protected void onStart() {
        super.onStart();
        final Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameET.getText().toString();
                Intent intent = new Intent(MainActivity.this,Activity2.class);
                intent.putExtra("name",name);
                startActivity(intent,bundle);
            }
        });

    }
}
