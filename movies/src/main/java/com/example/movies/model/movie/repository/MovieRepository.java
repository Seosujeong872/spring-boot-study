package com.example.movies.model.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.movies.model.movie.entity.MovieEntity;

public interface MovieRepository extends JpaRepository<MovieEntity ,Long> {
    
    
}
