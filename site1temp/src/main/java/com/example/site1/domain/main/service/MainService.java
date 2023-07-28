package com.example.site1.domain.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.site1.domain.main.dto.ResMainDTO;
import com.example.site1.domain.main.dto.UserDTO;
import com.example.site1.model.user.entity.UserEntity;
import com.example.site1.model.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

// 서비스: 데이터베이스에서 데이터 가져와서 컨트롤러에 주는 역할
@Service 
@RequiredArgsConstructor // Autowired 대신
public class MainService {

    private final UserRepository userRepository; // 유저정보를 가져올수 있는 애 소개

    public ResMainDTO getMainData(){

        // 모든 유저 가져오기
        List<UserEntity> userEntityList = userRepository.findAll();

        // dto 만들기
        List<UserDTO> userDTOList = new ArrayList<>();
        for(UserEntity userEntity : userEntityList){
            UserDTO userDTO = new UserDTO(userEntity.getId());
            userDTOList.add(userDTO);
        }
       
        ResMainDTO resMainDTO = new ResMainDTO(userDTOList);
        return resMainDTO;
    }
}
