package com.example.movies.domain.main.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.movies.domain.main.dto.MainPageDTO;
import com.example.movies.domain.main.service.MainService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
    
    private final MainService mainService;

    @GetMapping("/main")
    public ModelAndView mainPage(){
        // String targetDate = "20230813"; // 예시로 특정 날짜 지정

        // 오늘 날짜 가져오기
        LocalDate now = LocalDate.now();

        // 하루 뺀 날짜 계산
        LocalDate minusDays = now.minusDays(1);

        // 원하는 날짜 형식으로 포맷팅
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String targetDate = minusDays.format(formatter);

       

        // mainService통해서 해당 날짜의 mainPageDTO 가져오기.
        MainPageDTO mainPageDTO = mainService.getMainPageDTOByTargetDate(targetDate);

       

        // ModelAndView 객체 생성.
        ModelAndView modelAndView = new ModelAndView();



        // 가져온 데이터 dto라는 이름으로 modelAndView에 추가.
        modelAndView.addObject("dto", mainPageDTO);

        // 보여쥴 뷰 이름.
        modelAndView.setViewName("main/mainPage");
       

        return modelAndView;
    }

}
