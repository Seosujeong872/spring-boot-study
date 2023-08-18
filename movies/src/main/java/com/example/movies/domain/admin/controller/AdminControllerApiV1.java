package com.example.movies.domain.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.movies.domain.admin.dto.ReqAdminMovieUpdateDTO;
import com.example.movies.domain.admin.service.AdminServiceApiV1;

@RestController // RestApi 컨트롤러임을 나타냄 (Http 요청에 따라 데이터 처리하고 응답 반환)

@RequestMapping("/api/v1/admin")
public class AdminControllerApiV1 {
    
    @Autowired
    private AdminServiceApiV1 adminServiceApiV1;

    @PostMapping("/insert-movie")
    public ResponseEntity<?> insertMovie(){
        
        //adminServiceApiV1의 insertMovie 호출해서 정보저장하고 
        //ResponseEntity 반환
        return adminServiceApiV1.insertMovie();
    }

    @PutMapping("/update-movie")
    public ResponseEntity<?> updateMovie(@RequestBody ReqAdminMovieUpdateDTO dto){

        return adminServiceApiV1.updateMovie(dto);

    }

}
