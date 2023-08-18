package com.example.movies.domain.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString
public class ReqAdminMovieUpdateDTO {

    private Movie movie;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    @ToString
    public static class Movie {


        private Long idx;
        private String movieName;
        private String movieDate;
        private String grade;
        private String country;
        private Integer movieTime;
        private String summary;
        private String poster;

        

    }
}
