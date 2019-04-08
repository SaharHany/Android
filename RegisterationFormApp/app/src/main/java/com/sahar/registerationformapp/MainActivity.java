package com.sahar.registerationformapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onRadioBtnClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        if(checked){
            switch (view.getId()){
                case R.id.femaleRB:
                    Toast.makeText(this, "You are female", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.maleRB:
                    Toast.makeText(this, "You are male", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
