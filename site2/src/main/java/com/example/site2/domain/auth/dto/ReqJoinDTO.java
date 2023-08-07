package com.example.site2.domain.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReqJoinDTO {

    private User user;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class User { // ReqJoinDTO안에서만 쓸 수 있는 User /

        private String id;
        private String password;
    }
}
