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
    private List<String> movieRankAndTitleList;

    // private List<String> moviePosterUrlList;

}
