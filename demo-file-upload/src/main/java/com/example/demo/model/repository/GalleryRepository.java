package com.example.demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.GalleryEntity;

@Repository
public interface GalleryRepository extends JpaRepository<GalleryEntity, Long> {
    
}
