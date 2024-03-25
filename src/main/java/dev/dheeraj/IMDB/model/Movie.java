package dev.dheeraj.IMDB.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel{
    private String title;
    private String description;
    private int movieRuntime;
    @ManyToMany
    private List<Actor> actors;
    private int releaseYear;
    private int releaseMonth;
    private float rating;
    private List<String> genres;
    private List<String> languages;

    public Movie addGenre(String genre)
    {
        if(genres == null)
        {
            genres = new ArrayList<>();
        }
        this.genres.add(genre);
        return this;
    }

}
