package dev.dheeraj.IMDB.service;

import dev.dheeraj.IMDB.model.Actor;
import dev.dheeraj.IMDB.model.Movie;
import dev.dheeraj.IMDB.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ActorService actorService;

    public Movie saveMovie(Movie Movie)
    {
        return movieRepository.save(Movie);
    }

    public Movie getMovieByTitle(String title)
    {
        return movieRepository.findMovieByTitle(title);
    }

    public List<Movie> getMoviesByRating()
    {
        List<Movie> movies = movieRepository.findAll();
        MovieSorter sorter = new MovieSorter();
        Collections.sort(movies,sorter);
        return movies;
    }

    public List<Movie> getMovieByGenres(String genre)
    {
        List<Movie> allMovies = movieRepository.findAll();
        List<Movie> moviesByGenreList = new ArrayList<>();
        for (int i = 0; i < allMovies.size(); i++) {
            List<String> movieGenres = allMovies.get(i).getGenres();
            for (int j = 0; j < movieGenres.size(); j++) {
                if(movieGenres.get(j).equals(genre))
                {
                    moviesByGenreList.add(allMovies.get(i));
                }
            }
        }
        return moviesByGenreList;
    }

    public List<Movie> getMoviesByReleaseYear(int year)
    {
        return movieRepository.findMoviesByReleaseYear(year);
    }

}
