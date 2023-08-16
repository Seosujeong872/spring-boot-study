package com.example.movies.domain.main.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class MainPageDTO {
    
    private List<MovieRank> movieRankAndTitleList;
    private List<MoviePoster> moviePosterPathList;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class MovieRank {

        private int rank;
        private String movieName;

    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class MoviePoster {

        private String posterPath;

    }

}
