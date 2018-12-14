package com.example.android.retrofittutorial.App;

import com.example.android.retrofittutorial.Fixtures.FixturesResult;
import com.example.android.retrofittutorial.Standings.StandingsResult;
import com.example.android.retrofittutorial.TopScorers.TopscorersResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

// Interface for our api
public interface Api {

    @GET("standings/season/{seasonId}")
    Call<StandingsResult> getStandings(@Path("seasonId") int seasonId);

    @GET("rounds/{roundId}")
    Call<FixturesResult> getRoundWithFixtures(@Path("roundId") int roundId, @Query("include") String include);

    @GET("topscorers/season/{seasonId}")
    Call<TopscorersResult> getTopScorers(@Path("seasonId") int seasonId, @Query("include") String include);
}