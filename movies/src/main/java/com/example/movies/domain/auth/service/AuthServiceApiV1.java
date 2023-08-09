package com.example.movies.domain.auth.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.movies.domain.auth.dto.ReqJoinDTO;
import com.example.movies.domain.auth.dto.ReqLoginDTO;
import com.example.movies.model.user.entity.UserEntity;
import com.example.movies.model.user.repository.UserRepository;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)

public class AuthServiceApiV1 {

    private final UserRepository userRepository;

    @Transactional
    public ResponseEntity<?> join(ReqJoinDTO dto) {

        // 회원가입 정보 입력했는지 확인
        if (dto.getUser().getId() == null ||
                dto.getUser().getId().equals("") ||
                dto.getUser().getNickname() == null ||
                dto.getUser().getNickname().equals("") ||
                dto.getUser().getPassword() == null ||
                dto.getUser().getPassword().equals("") ||
                dto.getUser().getBirth() == null ||
                dto.getUser().getBirth().equals("")

        ) {
            return new ResponseEntity<>(
                    "회원정보를 입력해주세요",
                    HttpStatus.BAD_REQUEST);
        }

        Optional<UserEntity> userIdOptional = userRepository.findById(dto.getUser().getId());
        Optional<UserEntity> userNicknameOptional = userRepository.findByNickname(dto.getUser().getNickname());

        // 이미 아이디가 있을때
        if (userIdOptional.isPresent()) {
            return new ResponseEntity<>(
                    "이미 사용중인 아이디입니다.",
                    HttpStatus.BAD_REQUEST);
        }

        // 이미 닉네임이 있을때
        if (userNicknameOptional.isPresent()) {
            return new ResponseEntity<>(
                    "이미 사용중인 닉네임입니다.",
                    HttpStatus.BAD_REQUEST);
        }

        // 없으면 회원가입 처리
        UserEntity userEntity = UserEntity.builder()
                .id(dto.getUser().getId())
                .nickname(dto.getUser().getNickname())
                .password(dto.getUser().getPassword())
                .birth(dto.getUser().getBirth())
                .role("USER")
                .build();

        userRepository.save(userEntity);

        return new ResponseEntity<>(
                "회원가입에 성공하였습니다.",
                HttpStatus.OK);

    }

  
    public ResponseEntity<?> login( ReqLoginDTO dto, HttpSession session) {

        // 아이디 , 비밀번호 입력했는지 확인.
        if (dto.getUser().getId() == null ||
                dto.getUser().getId().equals("") ||
                dto.getUser().getPassword() == null ||
                dto.getUser().getPassword().equals("")) {
            return new ResponseEntity<>(
                    "아이디와 비밀번호를 입력해주세요",
                    HttpStatus.BAD_REQUEST);
        }

        Optional<UserEntity> userIdOptional = userRepository.findById(dto.getUser().getId());
        // Optional<UserEntity> userPwOptional = userRepository.findByPassword(dto.getUser().getPassword());
        
        if (!userIdOptional.isPresent()){
            return new ResponseEntity<>(
                "존재하지 않는 사용자 입니다. 아이디를 다시 입력해주세요.",
                HttpStatus.BAD_REQUEST
            );
        }

        UserEntity userEntity = userIdOptional.get();
        
        if(!userEntity.getPassword().equals(dto.getUser().getPassword())){
            return new ResponseEntity<>(
                "비밀번호가 일치하지 않습니다.",
                HttpStatus.BAD_REQUEST
            );
        }
         // 인증완료. 세션에 유저 정보 입력 
         session.setAttribute("idx", userEntity.getIdx());
         session.setAttribute("id", userEntity.getId());
         System.out.println(session);

         return new ResponseEntity<>(
            "로그인 성공",
            HttpStatus.OK
         );

    }
}
