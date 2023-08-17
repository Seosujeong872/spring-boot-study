package com.example.movies.apimodel.tmdb.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.movies.apimodel.tmdb.entity.TmdbMovie;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
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
        String apiUrl = TMDB_BASE_URL + "/search/movie?api_key=" + TMDB_API_KEY + "&query=" + movieName;

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

    // 영화 목록 가져오기
    public List<TmdbMovie> getPopularList() {
        List<TmdbMovie> tmdbMovieList = new ArrayList<>();

        // 1페이지 부터 10페이지까지
        for (int i = 1; i < 11; i++) {

            String apiUrl = TMDB_BASE_URL + "/movie/popular?api_key=" + TMDB_API_KEY + "&language=ko-KR&page=" + i;

            // restTemplate  사용해서  URL로 HTTP GET 요청보내기.
            ResponseEntity<TmdbMovie> response = restTemplate.getForEntity(
                    apiUrl,
                    TmdbMovie.class); // 응답은 TmdbMovie 클래스 형식으로 받아온다.

            // 응답이 성공일 경우
            if (response.getStatusCode().is2xxSuccessful()) {

                // 응답에서 가져온  TmdbMovie 객체를  tmdbMovieList 에 추가.
                tmdbMovieList.add(response.getBody());
            } else {
                System.out.println("/movie/popular 값을 찾아올 수 없음...");
            }
        }
        return tmdbMovieList;

    }

}
