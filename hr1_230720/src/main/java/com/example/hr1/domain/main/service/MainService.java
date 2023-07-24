package com.example.hr1.domain.main.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hr1.domain.main.dto.ReqInsertMainDTO;
import com.example.hr1.domain.main.dto.ReqUpdateMainDTO;
import com.example.hr1.domain.main.dto.ResMainDTO;
import com.example.hr1.domain.main.dto.ResUpdateMainDTO;
import com.example.hr1.model.regions.entity.RegionsEntity;
import com.example.hr1.model.regions.repository.RegionsRepository;



// 약속
// entity객체는 Service에서 빠져나가지 못한다
// entity -> dto

@Service
@Transactional(readOnly = true)
public class MainService {

    // Ioc 컨테이너에서 RegionsRepository타입의 객체를 가져온다
    // 의존성 주입 DI
    @Autowired
    private RegionsRepository regionsRepository;



    // 매개변수 수정
    @Transactional
    public void updateMainData(Integer regionId, ReqUpdateMainDTO reqUpdateMainDTO){
        // regionId 받아서 넣어주기
        RegionsEntity regionsEntity = regionsRepository.findByRegionId(regionId);
          if(regionsEntity == null){
            throw new RuntimeException("잘못된 요청입니다.");
        }
        // spring data jpa는 더티체킹을 사용한다.
        // 데이터베이스에서 가져온 데이터(엔티티)가 변경이 되면
        // 자동으로 update쿼리를 날린다.


        //dto에서 바뀐 역 이름 받아서 넣어주기
         regionsEntity.setRegionName(reqUpdateMainDTO.getRegionName());
    }
   
    @Transactional
    public void deleteMainData(Integer regionId){
        RegionsEntity regionsEntity = regionsRepository.findByRegionId(regionId);

        if(regionsEntity == null){
            throw new RuntimeException("이미 삭제된 지역입니다.");
        }
        regionsRepository.delete(regionsEntity);
    }



    @Transactional
    public void postMainData(ReqInsertMainDTO reqInsertMainDTO){

        long count = regionsRepository.count();

        RegionsEntity regionsEntity = RegionsEntity.builder()
        // .regionId((int)count + 1)
        .regionName(reqInsertMainDTO.getRegionsName())
        .build();

        regionsRepository.save(regionsEntity);
    }

    
    public List<ResMainDTO> getMainPageData(){

        List<RegionsEntity> regionsEntityList = regionsRepository.findAll();

        List<ResMainDTO> resMainDTOList = regionsEntityList
            .stream()
            .map((regionsEntity) -> ResMainDTO.fromEntity(regionsEntity))
            .toList();

        return resMainDTOList;

    }

    public ResUpdateMainDTO getResUpdateMainPageData(Integer regionsId){
        RegionsEntity regionsEntity = regionsRepository.findByRegionId(regionsId);
        return ResUpdateMainDTO.fromEntity(regionsEntity);
    }


    
}
