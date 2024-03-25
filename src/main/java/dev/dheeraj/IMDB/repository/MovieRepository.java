package dev.dheeraj.IMDB.repository;

import dev.dheeraj.IMDB.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
    Movie findMovieByTitle(String title);
    List<Movie> findMoviesByReleaseYear(int year);

    Movie getMovieById(int movieId);
}
