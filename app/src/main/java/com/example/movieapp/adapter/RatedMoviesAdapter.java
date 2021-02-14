package com.example.movieapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.R;
import com.example.movieapp.model.RatedMovies;

import java.util.List;

public class RatedMoviesAdapter extends RecyclerView.Adapter<RatedMoviesAdapter.RatedMovieViewHolder> {

    Context context;
    List<RatedMovies> ratedMoviesList;

    public RatedMoviesAdapter(Context context,List<RatedMovies> ratedMoviesList){
        this.context = context;
        this.ratedMoviesList = ratedMoviesList;
    }

    @NonNull
    @Override
    public RatedMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rated_row_items,parent,false);
        return new RatedMovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RatedMovieViewHolder holder, int position) {
        holder.imageView.setImageResource(ratedMoviesList.get(position).getImgURL());
    }

    @Override
    public int getItemCount() {
        return ratedMoviesList.size();
    }

    public static class RatedMovieViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public RatedMovieViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.categoryImage);
        }
    }
}
