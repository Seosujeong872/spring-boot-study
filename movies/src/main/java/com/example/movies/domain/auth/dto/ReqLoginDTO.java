package com.example.movies.domain.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ReqLoginDTO {
    private User user;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class User {
         private String id;
         private String password;
    }
}
