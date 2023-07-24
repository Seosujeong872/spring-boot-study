package com.example.site1.model.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.site1.model.post.entity.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity,Integer> {
    
    
}
