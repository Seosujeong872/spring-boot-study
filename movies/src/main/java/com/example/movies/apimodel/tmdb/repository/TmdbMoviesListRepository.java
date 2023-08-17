package com.example.movies.apimodel.tmdb.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.movies.apimodel.tmdb.entity.TmdbMoviesList;

@Service
public class TmdbMoviesListRepository {
    private static final String TMDB_API_KEY = "1d6bc56fae2d032656634b2ea17b1a88";
    private static final String TMDB_BASE_URL = "https://api.themoviedb.org/3";

    @Autowired
    private RestTemplate restTemplate;



    public TmdbMoviesList getMoviesList(){
        String apiUrl = TMDB_BASE_URL + "/movie/popular?api_key=" + TMDB_API_KEY + "language=ko-KR&page=1" ;

           ResponseEntity<TmdbMoviesList> response = restTemplate.getForEntity(
            apiUrl,
            TmdbMoviesList.class
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new RuntimeException("Failed to fetch movies list from TMDB API");
        }
    }
}
