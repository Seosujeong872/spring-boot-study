package com.example.my.domain.auth.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {

    @GetMapping("/auth/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("auth/login");
        return modelAndView;
    }

    @GetMapping("/auth/join")
    public ModelAndView join() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("auth/join");
        return modelAndView;
    }

    @GetMapping("/auth/logout")
    public ModelAndView logout(HttpSession session) {

        session.invalidate();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/auth/login");
        return modelAndView;
    }
}
