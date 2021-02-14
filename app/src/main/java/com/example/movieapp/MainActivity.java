package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.movieapp.adapter.CategoryAdapter;
import com.example.movieapp.adapter.RatedMoviesAdapter;
import com.example.movieapp.adapter.RecentlyViewedAdapter;
import com.example.movieapp.model.Category;
import com.example.movieapp.model.RatedMovies;
import com.example.movieapp.model.RecentlyViewed;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rateRecyclerView,categoryRecyclerView,recentlyViewedRecycler;
    RatedMoviesAdapter ratedMoviesAdapter;
    List<RatedMovies> ratedMoviesList;

    CategoryAdapter categoryAdapter;
    List<Category> categoryList;

    RecentlyViewedAdapter recentlyViewedAdapter;
    List<RecentlyViewed> recentlyViewedList;

    ImageView allCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rateRecyclerView = findViewById(R.id.ratedRecycler);
        categoryRecyclerView = findViewById(R.id.categoryRecycler);
        allCategory = findViewById(R.id.allCategoryImage);
        recentlyViewedRecycler = findViewById(R.id.recently_movie);

        allCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,AllCategory.class);
                startActivity(i);
            }
        });

        //adding data to model
        ratedMoviesList = new ArrayList<>();
        ratedMoviesList.add(new RatedMovies(1, R.drawable.ouija));
        ratedMoviesList.add(new RatedMovies(2,R.drawable.fight_club));
        ratedMoviesList.add(new RatedMovies(3,R.drawable.aqua));
        ratedMoviesList.add(new RatedMovies(4,R.drawable.sonic));
        ratedMoviesList.add(new RatedMovies(5,R.drawable.the_revenant));
        ratedMoviesList.add(new RatedMovies(6,R.drawable.shrek));

        //adding data to model
        categoryList = new ArrayList<>();
        categoryList.add(new Category(1, R.drawable.horror));
        categoryList.add(new Category(2, R.drawable.action));
        categoryList.add(new Category(3, R.drawable.adventure));
        categoryList.add(new Category(4, R.drawable.comedy));
        categoryList.add(new Category(5, R.drawable.drama));
        categoryList.add(new Category(6, R.drawable.classic));
        categoryList.add(new Category(7, R.drawable.sci_fi));
        categoryList.add(new Category(8, R.drawable.hollywood));

        //adding data to model
        recentlyViewedList = new ArrayList<>();
        recentlyViewedList.add(new RecentlyViewed("The Conjuring 2","Horror Movie","7.1/10\nimdb",R.drawable.conjuring));
        recentlyViewedList.add(new RecentlyViewed("Avatar","Adventure\nMovie","9/10\nimdb",R.drawable.avatar));
        recentlyViewedList.add(new RecentlyViewed("Charlie Chaplin","Classic Movie","8.6/10\nimdb",R.drawable.charlie_chaplin));
        recentlyViewedList.add(new RecentlyViewed("Harry Potter","Drama Movie","6/10\nimdb",R.drawable.harry_potter));
        recentlyViewedList.add(new RecentlyViewed("Joker","Action Movie","9.5/10\nimdb",R.drawable.joker));
        recentlyViewedList.add(new RecentlyViewed("Mission Impossible","Action Movie","6.5/10\nimdb",R.drawable.mission_impossible));
        recentlyViewedList.add(new RecentlyViewed("Star Wars","Sci-Fi Movie","5.2/10\nimdb",R.drawable.star_wars));
        recentlyViewedList.add(new RecentlyViewed("Titanic","Drama Movie","8.1/10\nimdb",R.drawable.titanic));
        recentlyViewedList.add(new RecentlyViewed("The Wolf Of\nWall Street","Comedy\nMovie","5.4/10\nimdb",R.drawable.wolf_of_wall_street));

        setRatedRecycler(ratedMoviesList);
        setCategoryRecycler(categoryList);
        setRecentlyViewedRecycler(recentlyViewedList);
    }

    private void setRatedRecycler(List<RatedMovies> dataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rateRecyclerView.setLayoutManager(layoutManager);
        ratedMoviesAdapter = new RatedMoviesAdapter(this,dataList);
        rateRecyclerView.setAdapter(ratedMoviesAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(this,categoryDataList);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }

    private void setRecentlyViewedRecycler(List<RecentlyViewed> recentlyViewedDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recentlyViewedRecycler.setLayoutManager(layoutManager);
        recentlyViewedAdapter = new RecentlyViewedAdapter(this,recentlyViewedDataList);
        recentlyViewedRecycler.setAdapter(recentlyViewedAdapter);
    }
}