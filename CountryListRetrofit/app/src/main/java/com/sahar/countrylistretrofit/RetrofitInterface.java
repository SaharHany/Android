package com.sahar.countrylistretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {

    @GET("/tutorial/jsonparsetutorial.txt")
    Call<List<Worldpopulation>> getWorldPopulation();
}
