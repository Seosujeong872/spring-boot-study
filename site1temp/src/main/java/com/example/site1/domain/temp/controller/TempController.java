package com.example.site1.domain.temp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.site1.domain.temp.dto.ReqTempDTO;

@Controller
public class TempController {
 
    @GetMapping("/temp") // GetMapping은  request , 유저가 경로를 치는것
    public String temp(ReqTempDTO reqTempDTO){
        System.out.println(reqTempDTO.getName());
        System.out.println(reqTempDTO.getAge());
        return "temp"; // response  파일명
    }

    @PostMapping("/temp") 
    public String temp1(ReqTempDTO reqTempDTO){
        System.out.println(reqTempDTO.getName());
        System.out.println(reqTempDTO.getAge());
        return "temp"; 
    }

    @PostMapping("/file")
    public String file(List<MultipartFile> files){ 
        for (MultipartFile multipartFile : files) {
            System.out.println(multipartFile.getOriginalFilename());
            System.out.println(multipartFile.getSize());
        }
        return "temp";
    }
}
