package com.example.movies.domain.admin.dto;

import com.example.movies.model.movie.entity.MovieEntity;

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
public class ResAdminMovieUpdatePageDTO {

    private Movie movie;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class Movie {



        private Long idx;
        private String movieName;
        private String poster;
        private String movieDate;
        private String country;
        private String grade;
        private Integer movieTime;
        private String summary;
        private String movieUrl;

        // 엔티티를 dto로 바꾸기 위함.
       public static Movie fromEntity(MovieEntity movieEntity){
            return Movie.builder()
            .idx(movieEntity.getIdx())
            .movieName(movieEntity.getMovieName())
            .poster(movieEntity.getPoster())
            .movieDate(movieEntity.getMovieDate())
            .country(movieEntity.getCountry())
            .grade(movieEntity.getGrade())
            .movieTime(movieEntity.getMovieTime())
            .summary(movieEntity.getSummary())
            .movieUrl(movieEntity.getMovieUrl())
            .build();
        }

}
}
