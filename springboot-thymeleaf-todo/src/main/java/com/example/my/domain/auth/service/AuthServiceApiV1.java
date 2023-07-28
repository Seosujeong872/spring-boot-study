package com.example.my.domain.auth.service;

import com.example.my.common.dto.LoginUserDTO;
import com.example.my.common.dto.ResponseDTO;
import com.example.my.common.exception.BadRequestException;
import com.example.my.domain.auth.dto.ReqJoinDTO;
import com.example.my.domain.auth.dto.ReqLoginDTO;
import com.example.my.model.user.entity.UserEntity;
import com.example.my.model.user.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthServiceApiV1 {

    private final UserRepository userRepository;

    public ResponseEntity<?> login(ReqLoginDTO dto, HttpSession session) {
        // 유효성 체크
        //   if (dto.getUser().getId() == null ||
        //         dto.getUser().getId().equals("") ||
        //         dto.getUser().getPassword() == null ||
        //         dto.getUser().getPassword().equals("")) {
        //     throw new BadRequestException("아이디나 비밀번호를 입력해주세요");
        //     // return new ResponseEntity<>(
        //     //         ResponseDTO.builder()
        //     //                 .code(1)
        //     //                 .message("아이디나 비밀번호를 입력해주세요")
        //     //                 .build(),
        //     //         HttpStatus.BAD_REQUEST);
        // }
        // 리파지토리에서 아이디로 삭제되지 않은 유저 찾기
        Optional<UserEntity> userEntityOptional = userRepository.findByIdAndDeleteDateIsNull(dto.getUser().getId());
       
        // 없으면 (존재하지 않는 사용자입니다.) 메시지 리턴
        if(userEntityOptional.isEmpty()){
            throw new BadRequestException("존재하지 않는 사용자입니다.");
            // return new ResponseEntity<>(
            //         ResponseDTO.builder()
            //                 .code(1)
            //                 .message("존재하지 않는 사용자입니다.")
            //                 .build(),
            //         HttpStatus.BAD_REQUEST);
        }
        UserEntity userEntity = userEntityOptional.get();

        // 비밀번호가 일치하지 않으면 (비밀번호가 일치하지 않습니다.) 메시지 리턴
        if(!userEntity.getPassword().equals(dto.getUser().getPassword())){
            throw new BadRequestException("비밀번호가 일치하지 않습니다.");
            //  return new ResponseEntity<>(
            //         ResponseDTO.builder()
            //                 .code(1)
            //                 .message("비밀번호가 일치하지 않습니다.")
            //                 .build(),
            //         HttpStatus.BAD_REQUEST);
        }
       
        // 세션에 로그인 유저 정보 저장
        session.setAttribute("dto", LoginUserDTO.of(userEntity));

        // 응답 데이터로 리턴하기 (로그인에 성공하였습니다.)
        return  new ResponseEntity<>(
            ResponseDTO.builder()
                    .code(0)
                    .message("로그인에 성공하였습니다.")
                    .build(),
            HttpStatus.OK
        );
    }

    @Transactional
    public ResponseEntity<?> join(ReqJoinDTO dto) {
        // 회원가입 정보 입력했는지 확인
        // if( dto.getUser()==null ||
        //     dto.getUser().getId() == null ||
        //     dto.getUser().getId().equals("") ||
        //     dto.getUser().getPassword() ==null ||
        //     dto.getUser().getPassword().equals("")
        // ){
        //     // 처리하기 귀찮아서 던짐.
        //     throw new BadRequestException("아이디나 비밀번호를 입력해주세요.");
            // return new ResponseEntity<>( 
            // ResponseDTO.builder()
            // .code(1)
            // .message("아이디나 비밀번호를 입력해주세요")
            // .build(),
            // HttpStatus.BAD_REQUEST
            // );
        // }
        // 리파지토리에서 아이디로 유저 찾기
        Optional<UserEntity> userEntityOptional = userRepository.findById(dto.getUser().getId());
        // optional - null  체크 하기위해서 쓴다
        
        // 있으면 (이미 존재하는 아이디입니다.) 메시지 리턴
        if(userEntityOptional.isPresent()){

            throw new BadRequestException("이미 존재하는 아이디 입니다.");
            // return new ResponseEntity<>(
            //     ResponseDTO.builder()
            //     .code(1)
            //     .message("이미 존재하는 아이디입니다.")
            //     .build(),
            //     HttpStatus.BAD_REQUEST
            // );
        }
        // 없으면 회원가입 처리
        UserEntity userEntity = UserEntity.builder()
        .id(dto.getUser().getId())
        .password(dto.getUser().getPassword())
        .createDate(LocalDateTime.now())
        .build();

        userRepository.save(userEntity);

        //응답 데이터로 리턴하기 (회원가입에 성공하였습니다.)
        return  new ResponseEntity<>(
            ResponseDTO.builder()
                    .code(0)
                    .message("회원가입에 성공하였습니다.")
                    .build(),
            HttpStatus.OK
        );
    }


}
