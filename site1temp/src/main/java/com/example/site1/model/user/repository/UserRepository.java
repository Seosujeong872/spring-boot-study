package com.example.site1.model.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.site1.model.user.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
   
    // 리파지토리야 유저의 idx를 줄테니까 
    // 해당 idx를 가진  UserEntity를 리턴해줘
    // UserEntity findByIdx(Integer idx);

    // 리파지토리야 유저의 idx를 줄테니까 
    // 해당 id를 가진  UserEntity를 리턴해줘

    UserEntity  findById(String id);
    // 리턴받을거         주는거

     // 리파지토리야 유저의 idx를 줄테니까 
    // 해당 idx를 가진  Optional<UserEntity> 리턴해줘

    Optional<UserEntity>  findByIdx(Integer idx);
} 
