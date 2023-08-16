package com.example.movies.domain.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.movies.domain.main.service.MainServiceApiV1;

@RestController
public class MainControllerApiV1 {

    // @Autowired
    // private KobisReposiory kobisReposiory;

    @Autowired
    private MainServiceApiV1 mainServiceApiV1;

    @GetMapping("/api/v1/test")
    public ResponseEntity<?> getMovieRankAndTitleList() {
        String targetDate = "20230813"; // 예시로 특정 날짜 지정
        return mainServiceApiV1.getMovieRankAndTitleList(targetDate);
        
    }

}