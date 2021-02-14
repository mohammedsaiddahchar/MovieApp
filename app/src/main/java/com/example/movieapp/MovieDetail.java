package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieDetail extends AppCompatActivity {

    ImageView imageView,back;
    TextView movieName,movieDesc,movieRate;

    String name,desc,rate;
    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        Intent intent = getIntent();

        name = intent.getStringExtra("name");
        desc = intent.getStringExtra("description");
        rate = intent.getStringExtra("rate");
        image = intent.getIntExtra("image",R.drawable.conjuring);

        movieName = findViewById(R.id.movieName);
        movieDesc = findViewById(R.id.movieDesc);
        movieRate = findViewById(R.id.movieRate);
        imageView = findViewById(R.id.movieImage);

        movieName.setText(name);
        movieDesc.setText(desc);
        movieRate.setText(rate);

        imageView.setImageResource(image);
        back = findViewById(R.id.back2);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MovieDetail.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}