package com.example.my.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthenticationSuccessHandler authenticationSuccessHandler;
    private final AuthenticationFailureHandler authenticationFailureHandler;
    private final LogoutSuccessHandler logoutSuccessHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf(config -> config.disable());

//        httpSecurity.headers(config -> config
//                .frameOptions(frameOptionsConfig -> frameOptionsConfig
//                        .disable()
//                )
//        );
//
//        httpSecurity.authorizeHttpRequests(config -> config
//                .requestMatchers(PathRequest.toH2Console())
//                .permitAll()
//        );

        httpSecurity.authorizeHttpRequests(config -> config
                .requestMatchers("/css/**", "/js/**", "/assets/**", "/favicon.ico") 
                .permitAll() // 해당 주소로 들어오는 애들 모두 허용.(인증없이)
                .requestMatchers("/js/admin*.js", "/h2/**", "/temp/**")
                .hasRole("ADMIN") // "ADMIN" 역할 가진거만 작동가능...?
        );

        httpSecurity.authorizeHttpRequests(config -> config
                // 매칭되는 주소들
                .requestMatchers("/auth/**", "/api/*/auth/**")
                // 모두 허용
                .permitAll()
                // 매칭되는 주소들
                .requestMatchers("/admin/**", "/api/*/admin/**")
                // ADMIN 역할을 가진 사람만 허용
                .hasRole("ADMIN")
                // 나머지 모든요청들은
                .anyRequest() 
                // 로그인이 된 사람만 허용
                .authenticated() 
        );

        httpSecurity.formLogin(config -> config
                // 로그인페이지 매핑 주소
                .loginPage("/auth/login") // 로그인페이지는 컨트롤러에 만들어 놓아야한다.
                // 로그인 api요청시 사용할 주소 
                .loginProcessingUrl("/api/v1/auth/login")
                // 로그인 아이디 파라미터명 (input 태그 name)
                .usernameParameter("id")
                // 로그인 비밀번호 파라미터명 (input 태그 name)
                .passwordParameter("password")
                // 로그인 처리 성공시 유저에게 보낼 내용
                .successHandler(authenticationSuccessHandler)
                // 로그인 처리 실패시 유저에게 보낼 내용
                .failureHandler(authenticationFailureHandler)
                // 모두 허용
                .permitAll()
        );

        httpSecurity.logout(config -> config
                .logoutUrl("/auth/logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessHandler(logoutSuccessHandler)
                .permitAll()
        );

        return httpSecurity.getOrBuild();
    }

}
