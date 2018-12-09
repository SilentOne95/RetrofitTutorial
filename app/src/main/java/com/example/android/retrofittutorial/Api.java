package com.example.android.retrofittutorial;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

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

    // Send request with Query annotation to set 'userId' parameter with name userId
    @GET("/posts")
    Call<ResponseBody> getPostsByUserId(@Query("userId") int userId);
}