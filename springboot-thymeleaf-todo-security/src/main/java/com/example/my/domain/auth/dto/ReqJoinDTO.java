package com.example.my.domain.auth.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ReqJoinDTO {

    @Valid
    @NotNull(message = "회원 정보를 입력해주세요.")
    private User user;

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class User {
        @NotBlank(message = "아이디를 입력해주세요.")
        private String id;
        @NotBlank(message = "비밀번호를 입력해주세요.")
        private String password;
    }

}
