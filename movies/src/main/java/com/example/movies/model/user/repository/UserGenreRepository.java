package com.example.movies.model.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.movies.model.user.entity.UserGenreEntity;

public interface UserGenreRepository extends JpaRepository<UserGenreEntity,Long>{

    List<UserGenreEntity> findByIdx(Long idx);

  

    
}
