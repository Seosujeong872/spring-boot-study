package com.example.hr1.model.employees.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hr1.model.employees.entity.EmployeesEntity;


public interface EmployeesRepository extends JpaRepository<EmployeesEntity, Integer> {
    Optional<EmployeesEntity> findByEmployeeId(Integer employeeId);

    List<EmployeesEntity> findByFirstNameContainingIgnoreCase(String firstName);
}
