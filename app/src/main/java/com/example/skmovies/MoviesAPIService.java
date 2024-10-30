package com.example.skmovies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesAPIService {

    @GET("movie/popular")
    Call<Result> getResults(@Query("api_key") String apiKey);
}
