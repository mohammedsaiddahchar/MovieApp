package com.example.movieapp.model;

import android.graphics.drawable.Drawable;

public class RecentlyViewed {
    String name;
    String description;
    String rate;
    int imageURL;


    public RecentlyViewed(String name, String description, String rate, int imageURL) {
        this.name = name;
        this.description = description;
        this.rate = rate;
        this.imageURL = imageURL;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public int getImageURL() {
        return imageURL;
    }

    public void setImageURL(int imageURL) {
        this.imageURL = imageURL;
    }


}
