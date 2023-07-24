package com.example.site1.model.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.site1.model.user.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    
    UserEntity findByIdx(Integer idx);
    List<UserEntity> findById(String id);
    UserEntity findByIdxAndId(Integer idx,String id);
}
