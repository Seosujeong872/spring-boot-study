package com.example.hr1.domain.emp.dto;

import java.util.List;

import com.example.hr1.model.employees.entity.EmployeesEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class EmpTableDTO {

    private Integer employeeId;
    private String firstName;

    public static EmpTableDTO fromEntity(EmployeesEntity employeesEntity) {
        return EmpTableDTO.builder()
                .employeeId(employeesEntity.getEmployeeId())
                .firstName(employeesEntity.getFirstName())
                .build();
    }

    public static List<EmpTableDTO> fromEntityList(List<EmployeesEntity> employeesEntityList) {
        return employeesEntityList
        .stream()
        .map((employeesEntity) -> fromEntity(employeesEntity))
        .toList();
    }

}
