package com.example.site1.domain.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.site1.domain.main.dto.ResMainDTO;
import com.example.site1.model.user.entity.UserEntity;
import com.example.site1.model.user.repository.UserRepository;

@Service
public class MainService {
    @Autowired
    private UserRepository userRepository;

    public List<ResMainDTO> getMainPageData(){
        List<UserEntity> siteEntityList = userRepository.findAll();
        List<ResMainDTO> resMainDTOList = siteEntityList
            .stream()
            .map((siteEntity)->ResMainDTO.fromEntity(siteEntity))
            .toList();
        return resMainDTOList;
    }
}
