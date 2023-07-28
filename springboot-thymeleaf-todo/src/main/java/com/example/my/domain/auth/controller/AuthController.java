package com.example.my.domain.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

    // ModelAndView 방식
    // @GetMapping("/auth/login")
    // public ModelAndView login() {
    //     ModelAndView modelAndView = new ModelAndView();
    //     modelAndView.setViewName("auth/login");
    //     return modelAndView;
    // }

    // String 방식
    @GetMapping("/auth/login")
    public String login(Model model) {
        model.addAttribute("dto", "hong");
        return "auth/login";
    }


    // @GetMapping("/auth/join")
    // public ModelAndView join() {
    //     ModelAndView modelAndView = new ModelAndView();
    //     modelAndView.setViewName("auth/join");
    //     return modelAndView;
    // }
    
    @GetMapping("/auth/join")
    public String join() {
       return "/auth/join";
    }

    // @GetMapping("/auth/logout")
    // public ModelAndView logout(HttpSession session) {

    //     session.invalidate();
    //     // invalidate 유효하지않게 만든다.

    //     ModelAndView modelAndView = new ModelAndView();
    //     modelAndView.setViewName("redirect:/auth/login");
    //     //  rdirect 다른페이지로 이동
    //     return modelAndView;
    // }
    
    @GetMapping("/auth/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/auth/login";
    }
}
