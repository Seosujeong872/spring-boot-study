package com.example.site1.domain.second.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.site1.domain.second.dto.ResSecondDTO;
import com.example.site1.domain.second.service.SecondService;

@Controller
public class SecondController {

    @Autowired
    private SecondService secondService;
    
    @GetMapping("/second")
    public ModelAndView secondPage(){
        ModelAndView modelAndView = new ModelAndView();
        List<ResSecondDTO> resSecondDTOList = secondService.getSecondData();
        modelAndView.addObject("resSecondDTOList", resSecondDTOList);
        modelAndView.setViewName("second");
        return modelAndView;
    }
}
