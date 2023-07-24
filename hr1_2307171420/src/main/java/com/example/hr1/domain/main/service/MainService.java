package com.example.hr1.domain.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hr1.domain.main.dto.ResMainDTO;
import com.example.hr1.model.regions.entity.RegionsEntity;
import com.example.hr1.model.regions.repository.RegionsRepository;

// 약속
// entity객체는 Service에서 빠져나가지 못한다
// entity -> dto

@Service
public class MainService {

    // Ioc 컨테이너에서 RegionsRepository타입의 객체를 가져온다
    // 의존성 주입 DI
    @Autowired
    private RegionsRepository regionsRepository;

    public List<ResMainDTO> getMainPageData(){

        List<RegionsEntity> regionsEntityList = regionsRepository.findAll();

        List<ResMainDTO> resMainDTOList = regionsEntityList
            .stream()
            .map((regionsEntity) -> ResMainDTO.fromEntity(regionsEntity))
            .toList();

        return resMainDTOList;

    }


    
}
