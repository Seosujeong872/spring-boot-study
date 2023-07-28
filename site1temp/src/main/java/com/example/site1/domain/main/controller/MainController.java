package com.example.site1.domain.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.site1.domain.main.dto.ResMainDTO;
import com.example.site1.domain.main.service.MainService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;
    
    @GetMapping("/")
    public String getMainPage(Model model){

        ResMainDTO dto = mainService.getMainData(); // 서비스님 데이터 주세요.
        model.addAttribute("dto", dto);


        return "main"; //"main" 은 view 에 해당.
    }
}
