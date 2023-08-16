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
    }
}
