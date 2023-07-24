package com.example.hr1.domain.emp.dto;

import java.util.List;

import com.example.hr1.model.emp.entity.EmpEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class EmpTableDTO {
    private Integer employeeId;
    private String  firstName;

    public static EmpTableDTO fromEntity(EmpEntity empEntity){
        return EmpTableDTO.builder()
            .employeeId(empEntity.getEmployeeId())
            .firstName(empEntity.getFirstName())
            .build();
    }
    public static List<EmpTableDTO> fromEntityList(List<EmpEntity> empEntityList){
        return empEntityList
            .stream()
            .map((empEntity)->fromEntity(empEntity))
            .toList();
    }
}
