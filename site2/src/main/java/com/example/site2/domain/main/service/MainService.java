package com.example.site2.domain.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.site2.domain.main.dto.MainUserDTO;
import com.example.site2.domain.main.dto.ResMainDTO;
import com.example.site2.model.post.entity.PostEntity;
import com.example.site2.model.post.repository.PostRepository;
import com.example.site2.model.user.entity.UserEntity;
import com.example.site2.model.user.repository.UserRepository;

@Service
@Transactional(readOnly = true)
public class MainService {

    @Autowired //  UserRepository 에 의존
    private UserRepository userRepository;

    public ResMainDTO getMainData(){
        // 원두가져오기
       List<UserEntity> userEntityList = userRepository.findAll();
       // 아메리카노 컵 준비하기
        List<MainUserDTO> mainUserDTOList = new ArrayList<>();

        for (UserEntity userEntity : userEntityList ) {
            // 원두를 아메리카노로 만들기
            MainUserDTO mainUserDTO = new MainUserDTO(userEntity.getIdx(),userEntity.getId());
            // 아메리카노를 컵에 담기
            mainUserDTOList.add(mainUserDTO);
            
        }
        // 캐리어에 아메리카노들 담고 컨트롤러한테 넘겨주기
        return new ResMainDTO(mainUserDTOList);
    
}
}
