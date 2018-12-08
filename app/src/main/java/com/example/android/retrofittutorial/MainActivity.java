package com.example.android.retrofittutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Retrofit instance and set base url
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.ipify.org/")
                .build();

        Api api = retrofit.create(Api.class);

        // Sends request to get IP address
        api.getIp().enqueue(new Callback<ResponseBody>() {

            // Called when response is received
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Log.d("RetrofitTutorial - IP ", response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // Called when network exception happens
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    // Interface for our api
    interface Api {

        // Method which gets IP address
        @GET("/")
        Call<ResponseBody> getIp();
    }
}
