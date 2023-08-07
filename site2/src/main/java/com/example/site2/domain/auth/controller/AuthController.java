package com.example.site2.domain.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {
    
    @GetMapping("/login")
    public ModelAndView loginPage(HttpSession session){
        Object attribute = session.getAttribute("idx");
        Long idx = (Long) attribute; // 형변환
        System.out.println("로그인페이지 idx : " + idx);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping("/join")
    public ModelAndView joinPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("join");
        return modelAndView;
    }


}
