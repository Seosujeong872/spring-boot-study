package com.example.movies.apimodel.tmdb.entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder

public class TmdbMovie {

    private List<Result> results;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class Result {
        @JsonProperty("poster_path")
        private String posterPath;

        @JsonProperty("genre_ids")
        private List<Long> genreIds;

        @JsonProperty("id")
        private long id;

        @JsonProperty("original_language")
        private String originalLanguage;

        @JsonProperty("release_date")
        private String releaseDate;

        @JsonProperty("title")
        private String title;

        // @JsonProperty("original_title")
        // private String originalTitle;

        @JsonProperty("overview")
        private String overview;

        @JsonProperty("vote_average")
        private Double voteAverage;

      
    }
}
