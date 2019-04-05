package com.sahar.countrylistretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String BASE_URL = "http://www.androidbegin.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadJson();

    }

    private void loadJson() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        RetrofitInterface request = retrofit.create(RetrofitInterface.class);
        Call<>
    }
}
