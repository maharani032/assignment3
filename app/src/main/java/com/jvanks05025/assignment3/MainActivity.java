package com.jvanks05025.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView total_cases, total_recovered,total_deaths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        total_cases=findViewById(R.id.total_cases);
        total_recovered=findViewById(R.id.total_recovered);
        total_deaths=findViewById(R.id.total_deaths);
        getData();
    }

    private void getData() {
        Call<CovidTracker> call=RetrofitClient.getInstance().getMyApi().getData();

        call.enqueue(new Callback<CovidTracker>() {
            @Override
            public void onResponse(Call<CovidTracker> call, Response<CovidTracker> response) {
                Log.i("covidtraker",response.toString());
                if(response.code()==502){
                    Toast.makeText(MainActivity.this,"502",Toast.LENGTH_LONG).show();


                }else if(response.code()==200){
                    Toast.makeText(MainActivity.this,"200",Toast.LENGTH_LONG).show();



                }
                if (response.isSuccessful()){
                    Toast.makeText(MainActivity.this,"response successfull",Toast.LENGTH_LONG).show();
                    Log.i("covidtracker","response body !=null");
                }
            }

            @Override
            public void onFailure(Call<CovidTracker> call, Throwable t) {

            }

        });

    }
}