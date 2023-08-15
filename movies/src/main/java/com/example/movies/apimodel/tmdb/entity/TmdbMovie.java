package com.example.movies.apimodel.tmdb.entity;

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
    
    private results results;


    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class results{
       
         @JsonProperty("poster_path")
        private String poster_path;
    }
}
