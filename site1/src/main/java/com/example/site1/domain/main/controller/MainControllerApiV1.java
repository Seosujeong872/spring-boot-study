package com.example.site1.domain.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.site1.domain.main.service.MainServiceApiV1;

@RestController
@RequestMapping("/api/v1/main")
public class MainControllerApiV1 {
    @Autowired
     private MainServiceApiV1 mainServiceApiV1;

    @GetMapping
    public ResponseEntity<?> getUserList(){
        return mainServiceApiV1.getUserList();
    }

}
