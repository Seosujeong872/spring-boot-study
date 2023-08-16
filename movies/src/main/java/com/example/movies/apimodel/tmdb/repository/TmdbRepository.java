package com.example.movies.apimodel.tmdb.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.movies.apimodel.tmdb.entity.TmdbMovie;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TmdbRepository {
    private static final String TMDB_API_KEY = "1d6bc56fae2d032656634b2ea17b1a88";
    private static final String TMDB_BASE_URL = "https://api.themoviedb.org/3";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper; // objectMapper : JSON 데이터를 객체로 변환하기위해 사용.

    // public TmdbRepository(RestTemplate restTemplate) {
    // this.restTemplate = restTemplate;
    // }

    public TmdbMovie getMovieInfo(String movieName) {
        // 영화정보 가져오는 TMDb API 호출
        String apiUrl = TMDB_BASE_URL + "/search/movie?api_key=" + TMDB_API_KEY + "&query=" + movieName ;

        // TMDb API 호출 및 응답 처리
        String response = restTemplate.getForObject(apiUrl, String.class);

        try {
            TmdbMovie tmdbMovie = objectMapper.readValue(response, TmdbMovie.class);
            return tmdbMovie;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
