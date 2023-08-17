package com.example.movies.apimodel.tmdb.entity;

import java.util.Date;
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
public class TmdbMoviesList {
    private List<Result> results;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class Result {

        @JsonProperty("genre_ids")
        private List<Integer> genre_ids;

        @JsonProperty("id")
        private long id;

        @JsonProperty("original_language")
        private String original_language;

        @JsonProperty("poster_path")
        private String poster_path;

         @JsonProperty("release_date")
        private Date release_date;

         @JsonProperty("title")
        private String title;

         @JsonProperty("original_title")
        private String original_title;

        @JsonProperty("overview")
        private String overview;

        @JsonProperty("vote_average")
        private Double vote_average;

    }

}
