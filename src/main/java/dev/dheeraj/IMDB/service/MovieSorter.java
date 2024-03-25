package dev.dheeraj.IMDB.service;

import dev.dheeraj.IMDB.model.Movie;

import java.util.Comparator;

public class MovieSorter implements Comparator<Movie> {

    @Override
    public int compare(Movie o1, Movie o2) {
        if(o1.getRating() > o2.getRating())
        {
            return -1;
        }
        else if(o2.getRating() > o1.getRating())
        {
            return 1;
        }
        return 0;
    }
}
