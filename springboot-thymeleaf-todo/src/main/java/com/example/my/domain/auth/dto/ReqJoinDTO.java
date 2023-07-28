package com.example.my.domain.auth.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ReqJoinDTO {

    @Valid 
    @NotNull(message = "유저 정보를 입력해주세요") // user를 입력안하면 에러터짐
    private User user;

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class User {

        @NotBlank(message = "아이디를 입력해주세요")
        // @@NotBlank : null, 빈 문자열(""), 공백(" ") 모두 허용하지 않는다.
        @Size(min = 4, message = "아이디는 4자 이상 입력해주세요")
        private String id;

        @NotBlank(message = "비밀번호를 입력해주세요")
        @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=.*[A-Z])(?=.*[a-z]).{8,16}$", message = "비밀번호는 8~16자 영문 대소문자, 숫자, 특수문자를 사용하세요")
        private String password;
    }

}
