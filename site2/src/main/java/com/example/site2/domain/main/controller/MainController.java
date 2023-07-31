package com.example.site2.domain.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.site2.domain.main.dto.ResMainDTO;
import com.example.site2.domain.main.service.MainService;

@Controller
public class MainController {

    @Autowired
    private MainService mainService;

    // String 방식
    @GetMapping("/") // 유저한테 받는주소
    public String mainPage1(Model model){
        ResMainDTO dto = mainService.getMainData();
        model.addAttribute("dto", dto);
      return "main";
    }

    // ModelAndView 방식
    // @GetMapping("/") // 유저한테 받는주소
    // public ModelAndView mainPage(){
    //     ModelAndView modelAndView = new ModelAndView();  

    //     ResMainDTO dto = mainService.getMainData();
    //     modelAndView.addObject("dto", dto); 
    //     modelAndView.setViewName("main"); // 파일경로
    //     return modelAndView;
    // }
}
