package com.example.demo.domain.main.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.domain.main.dto.ResMainDTO;
import com.example.demo.domain.main.service.MainService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    @GetMapping("/")
    public String mainPage(Model model){

        ResMainDTO dto = mainService.getMainData();

        model.addAttribute("dto", dto);

        return "temp";
    }

    @PostMapping("/gallery")
    public String saveGallery(MultipartFile file) throws IOException{

        mainService.saveGallery(file);

        return "redirect:/";
    }
    
}
