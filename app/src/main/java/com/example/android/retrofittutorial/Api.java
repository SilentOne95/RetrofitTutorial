package com.example.android.retrofittutorial;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

// Interface for our api
public interface Api {

    // Get IP address
    @GET("/")
    Call<ResponseBody> getIp();

    // Send get request
    @GET("/users")
    Call<ResponseBody> getUsers();

    // Post user's info to server
    @POST("/users")
    Call<ResponseBody> postUser(@Body RequestBody requestBody);
}