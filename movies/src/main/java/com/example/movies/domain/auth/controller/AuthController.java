package com.example.movies.domain.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.movies.domain.auth.dto.JoinPageDTO;
import com.example.movies.domain.auth.service.AuthService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor // final로 선언된 변수에 자동으로 알맞은 값을 할당해줌.
public class AuthController {

    private final AuthService authService;

    @GetMapping("/auth/join")
    public ModelAndView join() {
        ModelAndView modelAndView = new ModelAndView();
        // 서비스에서 데이터 가져오기
        JoinPageDTO dto = authService.getAllGenres();
        modelAndView.addObject("dto", dto);
        modelAndView.setViewName("auth/join");
        return modelAndView;
    }

    @GetMapping("/auth/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("auth/login");
        return modelAndView;
    }

    public static void main(String[] args) {

        System.out.println("안녕하세요");
        System.out.println("반갑습니다");

    }
}
