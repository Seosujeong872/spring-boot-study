package com.example.movies.domain.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movies.domain.movie.dto.ResMoviePageDTO;
import com.example.movies.domain.movie.dto.ResMoviePageDTO.Movie;
import com.example.movies.model.movie.entity.MovieEntity;
import com.example.movies.model.movie.repository.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    // 영화 정보 가져와서 ResMoviePageDTO 생성해서 반환.
    public ResMoviePageDTO getResMoviePageDTO() {

        // 모든 영화 정보 조회
        List<MovieEntity> movieEntityList = movieRepository.findAll();

        // ResMoviePageDTO 객체를 빌더 패턴 사용해서 생성
        // movieEntityList 이용해서 영화 엔티티 Movie 객체로 변환.
        // movieList 에 담아서 ResMoviePageDTO 객체 생성 
        return ResMoviePageDTO.builder()
                .movieList(
                        movieEntityList.stream()
                                .map(movieEntity -> Movie.fromEntity(movieEntity))
                                .toList())
                .build();
    }
}
