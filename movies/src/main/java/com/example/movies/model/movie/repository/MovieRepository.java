package com.example.movies.model.movie.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.movies.model.movie.entity.MovieEntity;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity ,Long> {
    
    Optional<MovieEntity> findByIdx(Long idx); 
    List<MovieEntity> findByMovieName(String movieName);
    
}
