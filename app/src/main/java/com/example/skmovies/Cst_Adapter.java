package com.example.skmovies;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.skmovies.databinding.MovieItemBinding;

import java.util.ArrayList;
import java.util.List;

public class Cst_Adapter extends RecyclerView.Adapter<Cst_Adapter.Cst_ViewHolder>{

    Context context;
    ArrayList<Movie> movieArrayList = new ArrayList<>();

//    public Cst_Adapter(Context context) {
//        this.context = context;
//    }

    public Cst_Adapter(Context context, ArrayList<Movie> movieArrayList) {
        this.context = context;
        this.movieArrayList = movieArrayList;
    }

    @NonNull
    @Override
    public Cst_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("MainActivity2", "Cst_Adapter:" + movieArrayList.size());
        MovieItemBinding movieItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.movie_item,
                parent,
                false);
        return new Cst_ViewHolder(movieItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull Cst_ViewHolder holder, int position) {
        Movie movie = movieArrayList.get(position);
        holder.movieItemBinding.setMovie(movie);

    }

    @Override
    public int getItemCount() {
        Log.d("Size", "getItemCount:" + movieArrayList.size());
        return movieArrayList.size();
    }

//    public void setMovies(List<Movie> movies) {
//        this.movieArrayList.clear();
//        this.movieArrayList.addAll(movies);
//        notifyDataSetChanged();
//    }

    public class Cst_ViewHolder extends RecyclerView.ViewHolder{
        MovieItemBinding movieItemBinding;
        public Cst_ViewHolder(MovieItemBinding movieItemBinding) {
            super(movieItemBinding.getRoot());
            this.movieItemBinding = movieItemBinding;

            movieItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Item clicked" + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
