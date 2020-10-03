package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;
@Parcel
public class Movie {
    String backDropPath;
    String postPath;
    String title;
    String overview;
    double rating;
    int movieId;
    //for parcels
    public Movie() { }



    public Movie(JSONObject jsonObject) throws JSONException {
            postPath = jsonObject.getString("poster_path");
            backDropPath = jsonObject.getString("backdrop_path");
            title = jsonObject.getString("title");
            overview = jsonObject.getString("overview");
            rating = jsonObject.getDouble("vote_average");
            movieId = jsonObject.getInt("id");
    }
    public double getRating() {
        return rating;
    }

    public int getMovieId() {
        return movieId;
    }

    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<Movie>();
        for (int i = 0 ; i < movieJsonArray.length(); i++){
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }
    public  String getBackDropPath(){
        return String.format("https://image.tmdb.org/t/p/w342/%s", backDropPath);
    }
    public String getPostPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", postPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }
}
