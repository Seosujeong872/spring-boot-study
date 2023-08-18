package com.example.movies.domain.auth.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.movies.domain.auth.dto.ResJoinPageDTO;
import com.example.movies.domain.auth.dto.ResJoinPageDTO.Genre;
import com.example.movies.model.genre.entity.GenreEntity;
import com.example.movies.model.genre.repository.GenreRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AuthService {
    
    // final 멤버변수는 객체 생성시 꼭 값을 넣어 줘야한다
    // @RequiredArgsConstructor를 사용하면 final이 붙어있는 멤버변수를 초기화 하기위해 매개변수를 생성한다
    private final GenreRepository genreRepository;

    // 장르 목록 가져오기

    public ResJoinPageDTO getAllGenres() {

        List<GenreEntity> genreEntityList = genreRepository.findAll();

        return ResJoinPageDTO.builder()
                .genreList(
                        genreEntityList.stream()
                                .map(genreEntity -> Genre.fromEntity(genreEntity))
                                .toList())
                .build();
    }

}
