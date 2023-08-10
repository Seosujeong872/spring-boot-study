package com.example.movies.model.genre.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.movies.model.genre.entity.GenreEntity;

public interface GenreRepository extends JpaRepository<GenreEntity, Long> {

    Optional<GenreEntity> findByIdx(Long idx);

    Optional<GenreEntity> findByGenreName(String genreName);
}
