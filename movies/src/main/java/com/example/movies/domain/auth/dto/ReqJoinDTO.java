package com.example.movies.domain.auth.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ReqJoinDTO {
    private User user;
    private Genre genre;
    private UserGenre userGenre;

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class User {
        private Long idx;
        private String id;
        private String nickname;
        private String password;
        private LocalDate birth;
        private String role;
        
        
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class Genre{
        private Long idx;
        private String genreName;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class UserGenre{
        private Long idx;
        private Long userIdx;
        private Long genreIdx;
    }

}
