package com.example.movieapp.model;

public class RatedMovies {
    Integer id;
    Integer imgURL;

    public RatedMovies(Integer id, Integer imgURL) {
        this.id = id;
        this.imgURL = imgURL;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getImgURL() {
        return imgURL;
    }

    public void setImgURL(Integer imgURL) {
        this.imgURL = imgURL;
    }
}
