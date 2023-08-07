package com.example.movies.domain.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {
    
    @GetMapping("/auth/join")
    public ModelAndView join() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("auth/join");
        return modelAndView;
    }
}
