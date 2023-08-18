package com.example.movies.domain.admin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movies.domain.admin.dto.ResAdminMovieUpdatePageDTO;
import com.example.movies.domain.movie.dto.ResMoviePageDTO;
import com.example.movies.model.movie.entity.MovieEntity;
import com.example.movies.model.movie.repository.MovieRepository;

@Service

public class AdminService {

    @Autowired
    private MovieRepository movieRepository;

    public ResMoviePageDTO getMovieList() {

        List<MovieEntity> movieEntityList = movieRepository.findAll();

        return ResMoviePageDTO.builder()
                .movieList(
                        movieEntityList.stream()
                                .map(movieEntity -> ResMoviePageDTO.Movie.fromEntity(movieEntity))
                                .toList())
                .build();

    }

    public ResAdminMovieUpdatePageDTO getAdminMovieUpdateData(Long movieIdx){

        Optional<MovieEntity> movieEntityOptional = movieRepository.findByIdx(movieIdx);
        MovieEntity movieEntity = movieEntityOptional.get();

        return ResAdminMovieUpdatePageDTO.builder()
        .movie(ResAdminMovieUpdatePageDTO.Movie.fromEntity(movieEntity))
        .build();
    }
}
