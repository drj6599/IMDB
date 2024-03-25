package dev.dheeraj.IMDB.controller;

import dev.dheeraj.IMDB.dto.*;
import dev.dheeraj.IMDB.model.Movie;
import dev.dheeraj.IMDB.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;


    @PostMapping("/addMovie")
    public ResponseEntity createMovie(@RequestBody MovieRequestDto movieRequestDto)
    {
        try{
            String title = movieRequestDto.getTitle();
            if(title.isBlank() || title.isEmpty() || title == null)
            {
                throw new Exception("Invalid title for the movie");
            }
            float rating = movieRequestDto.getRating();
            if(rating < 0 || rating > 10){
                throw new Exception("Invalid Rating");
            }
            Movie movie = new Movie();
            movie.setTitle(movieRequestDto.getTitle());
            movie.setDescription(movieRequestDto.getDescription());
            movie.setMovieRuntime(movieRequestDto.getMovieRuntime());
            movie.setRating(movieRequestDto.getRating());
            movie.setReleaseMonth(movieRequestDto.getReleaseMonth());
            movie.setReleaseYear(movieRequestDto.getReleaseYear());
            movie.setCreatedAt(LocalDateTime.now());
            movie.setUpdatedAt(LocalDateTime.now());
            movie.setCreatedBy("Mrunal");
            movie.setUpdatedBy("Mrunal");
            movie.setGenres(movieRequestDto.getGenres());
            movie.setLanguages(movieRequestDto.getLanguages());
            Movie savedMovie = movieService.saveMovie(movie);
            return ResponseEntity.ok(savedMovie);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/moviesByRating")
    public ResponseEntity getMoviesByRating()
    {
        return ResponseEntity.ok(movieService.getMoviesByRating());
    }


    @GetMapping("/moviesByReleaseYear")
    public ResponseEntity getMoviesByReleaseYear(@RequestBody ReleaseYearRequestDto releaseYearRequestDto)
    {
        return ResponseEntity.ok(movieService.getMoviesByReleaseYear(releaseYearRequestDto.getYear()));
    }

}
