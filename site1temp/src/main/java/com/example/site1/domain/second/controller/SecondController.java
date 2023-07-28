package com.example.site1.domain.second.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.site1.domain.second.dto.ResSecondDTO;
import com.example.site1.domain.second.service.SecondService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SecondController {
    
    private final SecondService secondService;

    @GetMapping("/second")
    public String getSecondPage(Model model){

        ResSecondDTO dto = secondService.getSecondData();
        model.addAttribute("dto", dto);

        return "second";
    }
}
