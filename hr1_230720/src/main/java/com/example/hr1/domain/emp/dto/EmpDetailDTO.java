package com.example.hr1.domain.emp.dto;

import com.example.hr1.model.employees.entity.EmployeesEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class EmpDetailDTO {

    private Integer employeeId;
    private String firstName;
    private String lastName;
    private Double salary;

    public static EmpDetailDTO fromEntity(EmployeesEntity employeesEntity) {
        return EmpDetailDTO.builder()
                .employeeId(employeesEntity.getEmployeeId())
                .firstName(employeesEntity.getFirstName())
                .lastName(employeesEntity.getLastName())
                .salary(employeesEntity.getSalary())
                .build();
    }

}
