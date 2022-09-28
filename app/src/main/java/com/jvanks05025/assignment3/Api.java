package com.jvanks05025.assignment3;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface Api {
    String BASE_URL="https://disease.sh/";
    @GET("v3/covid-19/all")
    Call<CovidTracker> getData();
}
