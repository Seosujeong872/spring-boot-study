package com.example.movies.domain.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.movies.domain.auth.dto.ReqJoinDTO;
import com.example.movies.domain.auth.dto.ReqLoginDTO;
import com.example.movies.domain.auth.service.AuthServiceApiV1;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthControllerApiV1 {

    private final AuthServiceApiV1 authServiceApiV1;

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody ReqJoinDTO dto) {
        ResponseEntity<?> responseEntity = authServiceApiV1.join(dto);

        return responseEntity;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody ReqLoginDTO dto, HttpSession session) {
         return authServiceApiV1.login(dto, session);

    }
}
