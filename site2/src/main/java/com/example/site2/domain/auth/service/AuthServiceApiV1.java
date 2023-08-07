package com.example.site2.domain.auth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.site2.domain.auth.dto.ReqJoinDTO;
import com.example.site2.domain.auth.dto.ReqLoginDTO;
import com.example.site2.model.user.entity.UserEntity;
import com.example.site2.model.user.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
@Transactional(readOnly = true)
public class AuthServiceApiV1 {
 
    @Autowired
    private UserRepository userRepository;
    
    // 회원가입
    @Transactional // 데이터를 데이터베이스에 넣을 때 꼭 붙인다.
    public ResponseEntity<?> join(ReqJoinDTO reqJoinDTO){

        // 유저가 제대로된 데이터를 보냈는지 확인
        if(reqJoinDTO.getUser().getId()==null){
            return new ResponseEntity<>(
                "아이디를 입력해주세요",
                HttpStatus.BAD_REQUEST
            );
        }

        
        if(reqJoinDTO.getUser().getId().length()<3){
             return new ResponseEntity<>(
                "아이디는 3글자 이상 입력해주세요.",
                HttpStatus.BAD_REQUEST
            );
        }

        // DB에 넣기 전에 해당 id를 가진 유저가 있는지 찾고
        // 있으면 이미 사용중인 있으면 "이미 사용중인 아이디 입니다."" 라는 메세지 보내야한다.
        Optional<UserEntity> userEntityOptional = userRepository.findById(reqJoinDTO.getUser().getId());
        if(userEntityOptional.isPresent()){ // 존재하면
            return new ResponseEntity<>(
                "이미 사용중인 아이디입니다.",
                HttpStatus.BAD_REQUEST
            );
        }

        UserEntity userEntity = new UserEntity(null,reqJoinDTO.getUser().getId(),reqJoinDTO.getUser().getPassword());

        // insert into user values(...);
        userRepository.save(userEntity);

        return new ResponseEntity<>(
            "회원가입에 성공했습니다.",
            HttpStatus.OK
        );
    }

    public ResponseEntity<?> login (ReqLoginDTO dto, HttpSession session){
        
        // 
        Optional<UserEntity> userEntityOptional = userRepository.findById(dto.getUser().getId());

        // 엔티티가 null이면 아이디를 잘못 입력한 것
        if(userEntityOptional.isEmpty()){
            return new ResponseEntity<>(
                "해당 아이디가 존재하지 않습니다.",
                HttpStatus.BAD_REQUEST
            );
        }
        // 옵셔널에서 유저엔티티 가져오기
        UserEntity userEntity = userEntityOptional.get();

        // 비밀번호 체크해서 다르면 잘못 입력한 것
        if(!userEntity.getPassword().equals(dto.getUser().getPassword())){
            return new ResponseEntity<>(
                "비밀번호가 일치하지 않습니다.",
                HttpStatus.BAD_REQUEST
            );
        }

        // 인증완료. 세션에 유저 정보 입력 
        session.setAttribute("idx", userEntity.getIdx());
        session.setAttribute("id", userEntity.getId());

        // 컨트롤러에게 로그인 성공 객체 보내기
        return new ResponseEntity<>(
            "로그인에 성공하였습니다.",
            HttpStatus.OK
        );
    }



}
