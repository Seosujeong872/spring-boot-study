package com.example.hr1.model.emp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hr1.model.emp.entity.EmpEntity;

@Repository
public interface EmpRepository extends JpaRepository<EmpEntity,Integer> {
    Optional<EmpEntity> findByEmployeeId(Integer employeeId);
}
