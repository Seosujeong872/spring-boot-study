package com.example.site1.domain.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.site1.domain.main.dto.ResMainDTO;
import com.example.site1.domain.main.service.MainService;


@Controller
public class MainController {
    
    @Autowired
    private MainService mainService;

    @GetMapping("/")
    public ModelAndView mainPage(){
        ModelAndView modelAndView = new ModelAndView();
        List<ResMainDTO> resMainDTOList = mainService.getMainPageData();
        modelAndView.addObject("resMaindtoList", resMainDTOList);
        modelAndView.setViewName("main");
        return modelAndView;
    }
}
