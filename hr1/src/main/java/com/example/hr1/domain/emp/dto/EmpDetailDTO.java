package com.example.hr1.domain.emp.dto;

import com.example.hr1.model.emp.entity.EmpEntity;

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
    private String  firstName;
    private String lastName;
    private Double salary;

    public static EmpDetailDTO fromEntity(EmpEntity empEntity){
        return EmpDetailDTO.builder()
            .employeeId(empEntity.getEmployeeId())
            .firstName(empEntity.getFirstName())
            .lastName(empEntity.getLastName())
            .salary(empEntity.getSalary())
            .build();
    }
}
