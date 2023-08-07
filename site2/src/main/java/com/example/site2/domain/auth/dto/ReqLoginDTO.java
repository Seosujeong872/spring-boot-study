package com.example.site2.domain.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReqLoginDTO {
    // private LoginUserDTO loginUserDTO;
    
    private User user;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class User{
        private String id; 
        private String password;
    }
}
