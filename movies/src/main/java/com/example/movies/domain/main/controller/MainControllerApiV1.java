package com.example.movies.domain.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.movies.domain.main.service.MainServiceApiV1;

@Controller

public class MainControllerApiV1 {

    @Autowired
    private MainServiceApiV1 mainServiceApiV1;

    @GetMapping("/test")
    @ResponseBody
    public String MovieApi() {
        String targetDate = "20230813"; // 예시로 특정 날짜 지정
        String result = mainServiceApiV1.getMovieRanking(targetDate);

        System.out.println(result);
        return result;
        
    }
}