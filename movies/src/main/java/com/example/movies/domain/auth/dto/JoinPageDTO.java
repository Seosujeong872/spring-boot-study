package com.example.movies.domain.auth.dto;

import java.util.List;

import com.example.movies.model.genre.entity.GenreEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class JoinPageDTO {
    private List<Genre> genreList;

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class Genre{

        private Long idx;
        private String genreName;

        public static Genre fromEntity(GenreEntity genreEntity){
            return Genre.builder()
            .idx(genreEntity.getIdx())
            .genreName(genreEntity.getGenreName())
            .build();
        }
    }
}
