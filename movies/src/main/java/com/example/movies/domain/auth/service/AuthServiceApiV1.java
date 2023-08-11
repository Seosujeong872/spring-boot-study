package com.example.movies.domain.auth.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.movies.domain.auth.dto.JoinPageDTO;
import com.example.movies.domain.auth.dto.ReqJoinDTO;
import com.example.movies.domain.auth.dto.ReqLoginDTO;
import com.example.movies.domain.auth.dto.JoinPageDTO.Genre;
import com.example.movies.model.genre.entity.GenreEntity;
import com.example.movies.model.genre.repository.GenreRepository;
import com.example.movies.model.user.entity.UserEntity;
import com.example.movies.model.user.entity.UserGenreEntity;
import com.example.movies.model.user.repository.UserGenreRepository;
import com.example.movies.model.user.repository.UserRepository;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)

public class AuthServiceApiV1 {

    private final UserRepository userRepository;

    @Autowired
    private final GenreRepository genreRepository;
    
    private final UserGenreRepository userGenreRepository;

    @Transactional
    public ResponseEntity<?> join(ReqJoinDTO dto) {

        

        // 회원가입 정보 입력했는지 확인

        // 이미 아이디가 있을때

        // 이미 닉네임이 있을때

        // 데이터베이스에 유저 저장

        // 저장된 유저 idx 확인

        // 장르idx리스트 반복문

        // 유저장르 테이블에 

        // 유저장르 엔티티 만들어서

        // 2번유저
        // 1번장르

        // 2번유저
        // 5번장르

        // 2번유저
        // 7번장르


        // // 회원가입 정보 입력했는지 확인
        if (dto.getUser().getId() == null ||
                dto.getUser().getId().equals("") ||
                dto.getUser().getNickname() == null ||
                dto.getUser().getNickname().equals("") ||
                dto.getUser().getPassword() == null ||
                dto.getUser().getPassword().equals("") ||
                dto.getUser().getBirth() == null ||
                dto.getUser().getBirth().equals("") ||
                dto.getGenreIdxList().isEmpty()

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
       
        // 선호장르 선택 3개 안 했을 때
        
        // List<UserGenreEntity> userGenreList = userGenreRepository.findByUserEntity_id(dto.getGenreIdxList().)
        // if(userGenreList.size() < 3){
        //     return new ResponseEntity<>(
        //         "장르를 3개 선택해주세요",
        //         HttpStatus.BAD_REQUEST
        //     );
        // }

        


        // 없으면 회원가입 처리
        UserEntity userEntityForSaving = UserEntity.builder()
                .id(dto.getUser().getId())
                .nickname(dto.getUser().getNickname())
                .password(dto.getUser().getPassword())
                .birth(dto.getUser().getBirth())
                .role("USER")
                .build();
                
        // 회원가입
        UserEntity userEntity = userRepository.save(userEntityForSaving);

        // userEntity.getIdx();
 
        // 반복문
        for (Long genreIdx : dto.getGenreIdxList()) {

            // 장르 엔티티
            // Optional<GenreEntity> genreEntityOptional = genreRepository.findByIdx(genreIdx);
            GenreEntity genreEntity = GenreEntity.builder()
            .idx(genreIdx)
            .build();

            UserGenreEntity userGenreEntity = UserGenreEntity.builder()
            .userEntity(userEntity)
            .genreEntity(genreEntity)
            .build();

            userGenreRepository.save(userGenreEntity);
            
        }

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

    // 장르 목록 가져오기
    public JoinPageDTO getAllGenres() {
        
        List<GenreEntity> genreEntityList = genreRepository.findAll();


        return JoinPageDTO.builder()
        .genreList(
            genreEntityList.stream()
            .map(genreEntity -> Genre.fromEntity(genreEntity))
            .toList()
        )
        .build();
    }

}
