package com.example.hr1.domain.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hr1.domain.emp.dto.EmpDetailDTO;
import com.example.hr1.domain.emp.dto.EmpTableDTO;
import com.example.hr1.model.emp.entity.EmpEntity;
import com.example.hr1.model.emp.repository.EmpRepository;

@Service
public class EmpService {
    @Autowired
    private EmpRepository empRepository;

    public List<EmpTableDTO> getEmpListData(){

        return EmpTableDTO.fromEntityList(empRepository.findAll());
    }       

    public EmpDetailDTO getEmpDetailData(Integer employeeId){
        Optional<EmpEntity> empEntityOptional = empRepository.findByEmployeeId(employeeId);
        if(!empEntityOptional.isPresent()){
            throw new RuntimeException("잘못된 요청입니다.");
        }
        return EmpDetailDTO.fromEntity(empEntityOptional.get());

    }

}
