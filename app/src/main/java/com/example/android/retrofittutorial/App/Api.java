package com.example.android.retrofittutorial.App;

import com.example.android.retrofittutorial.Standings.StandingsResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

// Interface for our api
public interface Api {

    @GET("standings/season/{seasonId}")
    Call<StandingsResult> getStandings(@Path("seasonId") int seasonId);

}