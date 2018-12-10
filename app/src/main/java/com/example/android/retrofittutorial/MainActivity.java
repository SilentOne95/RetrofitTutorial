package com.example.android.retrofittutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
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

        // Send request by changing part of the url
        getPostsByChangingUrl();

        // Send request to url with different endpoint
        sendRequestToUrl();

        // Multipart
        uploadFile();

        // Send post request with form encoded data
        postPost();

        // Send request with two headers (in static way)
        getWithTwoHeaders();

        // ... dynamic way
        getWithTwoHeadersDynamic();

        // Task
        sendTaskRequest();
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
                // We can check result by displaying it using logs
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    public void getPostsByChangingUrl() {

        api.getPostsByIdToUrl(1).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                // We can check result by displaying it using logs
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    public void sendRequestToUrl() {

        api.sendRequest("https://api.ipify.org").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                // We can check result by displaying it using logs
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    public void uploadFile() {

        try {

            File file = new File(getCacheDir(), "hello.txt");
            FileWriter writer = new FileWriter(file);
            writer.append("Hello");
            writer.flush();
            writer.close();

            RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            MultipartBody.Part part = MultipartBody.Part.createFormData("file", file.getName(), requestBody);

            api.uploadFile("https://file.io/", part).enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    // We can check result by displaying it using logs
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {

                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void postPost() {

        String id = "1";
        String userId = "2";
        String title = "This is title";
        String body = "This is body";

        api.postPost(id, userId, title, body).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                // We can check result by displaying it using logs
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    public void getWithTwoHeaders() {

        api.sendRequestWithHeaders().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                // We can check result by displaying it using logs
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    public void getWithTwoHeadersDynamic() {

        String contentType = "application/json";
        String userAgent = "RetrofitExample";

        api.sendRequestWithHeadersDynamic(contentType, userAgent).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                // We can check result by displaying it using logs
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    public void sendTaskRequest() {

        String username = "myusername";
        String password = "mypassword";
        String userAndPassword = username + ":" + password;
        String authorization = "Basic " + Base64.encodeToString(userAndPassword.getBytes(), Base64.NO_WRAP);

        api.sendTaskRequest(authorization).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Log.d("RetrofitExample", response.body().string());
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