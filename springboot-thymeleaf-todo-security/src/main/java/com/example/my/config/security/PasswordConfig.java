package com.example.my.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration // 컴포넌트ㄴ는 클래스에 붙이고
public class PasswordConfig {

    @Bean // 빈은 함수에 붙인다.
    public PasswordEncoder passwordEncoder() { // 비밀번호 암호화 
            return new BCryptPasswordEncoder();
        }
    }


