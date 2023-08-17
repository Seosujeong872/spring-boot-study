package com.example.movies.domain.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movies.apimodel.tmdb.entity.TmdbMovie;
import com.example.movies.apimodel.tmdb.entity.TmdbMoviesList;
import com.example.movies.apimodel.tmdb.repository.TmdbMoviesListRepository;
import com.example.movies.model.movie.repository.MovieRepository;

@Service
public class MovieService {
      @Autowired
    private TmdbMoviesListRepository tmdbMoviesListRepository;

    @Autowired
    private MovieRepository movieRepository;

    public void MoviesFromTmdb() {
        TmdbMoviesList tmdbMoviesList = tmdbMoviesListRepository.getMoviesList();

        for (TmdbMoviesList tmdbMovie : tmdbMoviesList) {
            Movie movie = new Movie();
            movie.setTitle(tmdbMovie.getTitle());
            movie.setOverview(tmdbMovie.getOverview());
            // Set other fields as needed

            movieRepository.save(movie);
        }
    }
}
