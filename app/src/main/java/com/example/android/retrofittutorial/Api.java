package com.example.android.retrofittutorial;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

// Interface for our api
public interface Api {

    // Get IP address
    @GET("/")
    Call<ResponseBody> getIp();

    // Send get request
    @GET("/users")
    Call<ResponseBody> getUsers();

}