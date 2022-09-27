package com.jvanks05025.assignment3;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface Api {
    String BASE_URL="https://corona.lmao.ninja/";
    @Headers({"Cache-Control: max-age=640000"})
    @GET("v2/all")
    Call<CovidTracker> getData();
}
