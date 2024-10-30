package com.example.skmovies;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ViewModel extends AndroidViewModel {
    Repository myRepository;
    public ViewModel(@NonNull Application application) {
        super(application);
        this.myRepository = new Repository(application);
    }
    public LiveData<List<Movie>> getMovies(){
        return myRepository.getAllMovies();
    }
}
