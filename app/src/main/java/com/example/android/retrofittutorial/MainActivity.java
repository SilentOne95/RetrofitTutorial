package com.example.android.retrofittutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    Api api;
    RequestBody requestBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Retrofit instance and set base url
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();

        api = retrofit.create(Api.class);

        // Sends request to get IP address
        getUserIp();

        // Returns list of posts
        getListOfUsers();

        // Sample json string
        String json = "{\n" +
                "\t\"id\": 707,\n" +
                "\t\"name\": \"Marcin\"\n" +
                "}";

        // Create request body in which we send our json data
        requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        // Sends info in post request
        sendUserData();

        // Send single parameter using @Query
        getPostsByUserId();

        // Send request with multiple parameters
        getPostsByTwoParameters();

        // Send request with the same parameters
        getPostsByIds();

        // Send request with map of parameters
        getPostsWithMapOfParams();
    }

    public void getUserIp() {

        api.getIp().enqueue(new Callback<ResponseBody>() {
            // Called when response is received
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                // We can check result by displaying it using logs
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    public void getListOfUsers() {

        api.getUsers().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                // We can check result by displaying it using logs
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    public void sendUserData() {

        api.postUser(requestBody).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                // We can check result by displaying it using logs
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    public void getPostsByUserId() {

        api.getPostsByUserId(1).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                // We can check result by displaying it using logs
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    public void getPostsByTwoParameters() {

        int userId = 1;
        int postId = 2;
        api.getPostsByUserIdAndPostId(userId, postId).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                // We can check result by displaying it using logs
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    public void getPostsByIds() {
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);

        api.getPostsByIds(ids).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                // We can check result by displaying it using logs
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    public void getPostsWithMapOfParams() {
        Map<String, String> params = new HashMap<>();
        params.put("userId", "1");
        params.put("id", "2");

        api.getPostsByParams(params).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Log.d("RetrofitExample ", response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}