package com.example.skmovies;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    private Application application;

    public Repository(Application application) {
        this.application = application;
    }

    private MutableLiveData<List<Movie>> mutableLiveData = new MutableLiveData<>();
    private ArrayList<Movie> movieArrayList = new ArrayList<>();

    public MutableLiveData<List<Movie>> getAllMovies(){
        MoviesAPIService moviesAPIService = RetrofitInstance.getService();
        Call<Result> call = moviesAPIService.getResults(application.getApplicationContext().getString(R.string.api_key));
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result = response.body();
                if(result != null && result.getResult() != null){
                    movieArrayList = (ArrayList<Movie>) result.getResult();
                    mutableLiveData.setValue(movieArrayList);
                    Log.d(application.getApplicationContext().getString(R.string.app_name), "success " + mutableLiveData.getValue().get(0).getTitle());
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable throwable) {
                Log.e("Repository", "onFailure: " + throwable.getMessage());
                Toast.makeText(application.getApplicationContext(), "No internet", Toast.LENGTH_LONG).show();
                //Log.d(application.getApplicationContext().getString(R.string.app_name), "failed to fetch data");
            }
        });
        return mutableLiveData;
    }
}
