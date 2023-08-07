package com.example.movies.model.auth.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.movies.model.auth.entity.UserEntity;




public interface UserRepository extends JpaRepository<UserEntity,Long>{
    
    Optional<UserEntity> findByIdx(Long idx);

    Optional<UserEntity> findById(String id);

    Optional<UserEntity> findByNickname(String nickname);

    Optional<UserEntity> findByPassword(String password);

    Optional<UserEntity> findByBirth(LocalDate birth);

    Optional<UserEntity> findByRole(String role);
}
