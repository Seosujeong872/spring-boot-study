package com.example.hr1.model.regions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hr1.model.regions.entity.RegionsEntity;

@Repository
public interface RegionsRepository extends JpaRepository<RegionsEntity, Integer> {
    
}
