package com.example.my.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.example.my.config.security.auth.CustomAuthenticationFailureHandler;
import com.example.my.config.security.auth.CustomAuthenticationSuccessHandler;

import lombok.RequiredArgsConstructor;

@Configuration // config파일에 붙여줌.
@EnableWebSecurity // 시큐리티 적용한다는 뜻.
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
    private final CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {


        // csrf 보안 해제 ( 실무에서는 보안 적용 권장)

        httpSecurity.csrf(
            config -> config.disable()
            );

        // 요청 주소 인증 및 인가 세팅
        httpSecurity.authorizeHttpRequests(
            config -> config
            .requestMatchers("/css/**", "/js/**","/img/**")
             //위에 해당하는 주소를 인증 및 인가 없이 접속 가능하도록 함 
            .permitAll()
            .requestMatchers("/auth/**", "/api/v1/auth/**")
            .permitAll()
            .requestMatchers("/admin/**", "/api/*/auth/**")
            // 위에 해당하는 주소는 ADMIN 권한이 있는 사람만 접근할 수 있다.
            .hasRole("ADMIN")
            .anyRequest()// 나머지 모든 주소
            // 위에 해당하는 주소 로그인(인증)이 되어 있어야 한다.
            .authenticated()
        );

        httpSecurity.formLogin(
            config -> config
            // 실제 로그인 컨트롤러 메소드 경로
            .loginPage("/auth/login")
            // 가상의 주소를 넣는다.
            .loginProcessingUrl("id")
            .usernameParameter("password")
            .successHandler(customAuthenticationSuccessHandler)
            .failureHandler(customAuthenticationFailureHandler)
            .permitAll()
        );

        return httpSecurity.getOrBuild();
    }
}
