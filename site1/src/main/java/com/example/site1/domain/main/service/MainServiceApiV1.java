package com.example.site1.domain.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.site1.common.ResponseDTO;
import com.example.site1.domain.main.dto.ResMainApiDTO;
import com.example.site1.domain.main.dto.ResMainApiDTO.User;
import com.example.site1.model.user.entity.UserEntity;
import com.example.site1.model.user.repository.UserRepository;

@Service
@Transactional(readOnly = true)
public class MainServiceApiV1 {
    
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<?> getUserList(){
        List<UserEntity> userEntityList = userRepository.findAll();
         return new ResponseEntity<>(
            ResponseDTO.builder()
            .code(0)
            .message("유저 리스트 조회에 성공했습니다.")
            .data( ResMainApiDTO.of(userEntityList))
            .build(),
            HttpStatus.OK
         );
    }
}
