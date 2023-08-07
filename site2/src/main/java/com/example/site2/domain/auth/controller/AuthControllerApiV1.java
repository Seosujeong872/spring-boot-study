package com.example.site2.domain.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.site2.domain.auth.dto.ReqJoinDTO;
import com.example.site2.domain.auth.dto.ReqLoginDTO;
import com.example.site2.domain.auth.service.AuthServiceApiV1;

import jakarta.servlet.http.HttpSession;

@RestController // @RestController안에 @ResponseBody 있어서 생략가능 , Responsebody로 json으로 보내는 컨트롤러 
@RequestMapping("/api/v1/auth") // 주소값만 인식 , AuthController 와 분리하기 위해 붙인다.
public class AuthControllerApiV1 {

    @Autowired
    private AuthServiceApiV1 authServiceApiV1;
    
    @PostMapping("/join") // @PostMapping 데이터를 삽입하거나 받는 역할
    public @ResponseBody ResponseEntity<?> join( @RequestBody ReqJoinDTO dto){ // 아이디랑 비밀번호를 받아야한다. -> 받을 dto만들기 /@RequestBody 객체받을때 
        // json데이터를 받을 때 @RequestBody , @RequestBody 사용자 요청을 받고 (원래는 파싱 해야하는데  스프링이 바꿔줌)
        //  @ResponseBody json데이터로 바꿔줌. 서버에 응답해주기위해
        // 서버가 유저에게 보내는게 응답이다.
        // System.out.println(dto.getJoinUserDTO().getId());
        // System.out.println(dto.getJoinUserDTO().getPassword());

        ResponseEntity<?> responseEntity = authServiceApiV1.join(dto);

        return responseEntity;
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody ReqLoginDTO dto, HttpSession session){ // 아이디랑 비밀번호를 받아야한다. -> 받을 dto만들기
        // session 해당 유저가 입력한 정보가 들어가있다.

        return authServiceApiV1.login(dto, session);
    }
}
