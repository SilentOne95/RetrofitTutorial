package com.example.android.retrofittutorial;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

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

    // Send request with many parameters
    @GET("/posts")
    Call<ResponseBody> getPostsByUserIdAndPostId(@Query("userId") int userId, @Query("id") int postId);

    // Send request with parameters with the same name
    @GET("/posts")
    Call<ResponseBody> getPostsByIds(@Query("id") List<Integer> ids);

    // Send request with map of parameters
    @GET("/posts")
    Call<ResponseBody> getPostsByParams(@QueryMap Map<String, String> params);

    // Change part of the URL
    @GET("/posts/{id}")
    Call<ResponseBody> getPostsByIdToUrl(@Path("id") int id);

    // Sending request to url with different endpoint
    @GET
    Call<ResponseBody> sendRequest(@Url String url);

    // Multipart
    @Multipart
    @POST
    Call<ResponseBody> uploadFile(@Url String url, @Part MultipartBody.Part part);

    @Multipart
    @POST
    Call<ResponseBody> uploadAnotherFile(@Url String url,
                                         @Part("apikey") RequestBody apiKey,
                                         @Part("language") RequestBody language,
                                         @Part MultipartBody.Part file);

    // Sending post request to posts endpoint
    @FormUrlEncoded
    @POST("/posts")
    Call<ResponseBody> postPost(@Field("id") String id,
                                @Field("userId") String userId,
                                @Field("title") String title,
                                @Field("body") String body);
}