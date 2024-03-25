package dev.dheeraj.IMDB.dto;

import dev.dheeraj.IMDB.model.Actor;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class MovieRequestDto {
    private String title;
    private String description;
    private int movieRuntime;
    private int releaseYear;
    private int releaseMonth;
    private float rating;
    private List<String> genres;
    private List<String> languages;
}
