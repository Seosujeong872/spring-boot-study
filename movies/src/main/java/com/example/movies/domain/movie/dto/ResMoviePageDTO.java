package com.example.movies.domain.movie.dto;

import java.util.List;

import com.example.movies.model.movie.entity.MovieEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ResMoviePageDTO {

    private List<Movie> movieList;


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

       public static Movie fromEntity(MovieEntity movieEntity){
            return Movie.builder()
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

        private List<Genre> genreList;

        @NoArgsConstructor
        @AllArgsConstructor
        @Getter
        @Builder
        public static class Genre {
            private Long idx;
            private String genreName;



        }

       
    }

}
