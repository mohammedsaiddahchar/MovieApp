package com.example.movieapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.MovieDetail;
import com.example.movieapp.R;
import com.example.movieapp.model.RecentlyViewed;

import java.util.List;

public class RecentlyViewedAdapter extends RecyclerView.Adapter<RecentlyViewedAdapter.RecentlyViewedHolder> {

    Context context;
    List<RecentlyViewed> recentlyViewedList;

    public RecentlyViewedAdapter(Context context, List<RecentlyViewed> recentlyViewedList) {
        this.context = context;
        this.recentlyViewedList = recentlyViewedList;
    }

    @NonNull
    @Override
    public RecentlyViewedAdapter.RecentlyViewedHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recently_viewed_movies,parent,false);
        return new RecentlyViewedHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentlyViewedAdapter.RecentlyViewedHolder holder, int position) {

        holder.name.setText(recentlyViewedList.get(position).getName());
        holder.description.setText(recentlyViewedList.get(position).getDescription());
        holder.rate.setText(recentlyViewedList.get(position).getRate());
        holder.bg.setBackgroundResource(recentlyViewedList.get(position).getImageURL());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MovieDetail.class);
                intent.putExtra("name",recentlyViewedList.get(position).getName());
                intent.putExtra("description",recentlyViewedList.get(position).getDescription());
                intent.putExtra("rate",recentlyViewedList.get(position).getRate());
                intent.putExtra("image",recentlyViewedList.get(position).getImageURL());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return recentlyViewedList.size();
    }

    public static class RecentlyViewedHolder extends RecyclerView.ViewHolder{

        TextView name,description,rate,imageURL;
        ConstraintLayout bg;

        public RecentlyViewedHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.movie_name);
            description = itemView.findViewById(R.id.description);
            rate = itemView.findViewById(R.id.rate);
            bg = itemView.findViewById(R.id.recently_layout);
        }
    }
}
