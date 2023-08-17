package com.example.movies.model.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.movies.model.movie.entity.MovieGenreEntity;


public interface MovieGenreRepository extends JpaRepository<MovieGenreEntity,Long> {
   
    List<MovieGenreEntity> findByIdx(Long idx);
    
    List<MovieGenreEntity> findByMovieEntity_idx(Long idx);
}
