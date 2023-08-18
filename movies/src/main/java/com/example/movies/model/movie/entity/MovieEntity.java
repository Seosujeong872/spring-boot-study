package com.example.movies.model.movie.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MOVIE")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx", nullable = false, unique = true)
    private Long idx;

    @Column(name = "movie_name", nullable = false)
    private String movieName;

    @Column(name = "poster", nullable = false)
    private String poster;

    @Column(name = "movie_date", nullable = false)
    private String movieDate;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "grade")
    private String grade;

    @Column(name = "movie_time")
    private Integer movieTime;

    @Column(name = "summary", length = 100000000, nullable = false)
    private String summary;

    @Column(name = "movie_url")
    private String movieUrl;

    @OneToMany(mappedBy = "movieEntity")
    private List<MovieGenreEntity> movieGenreEntityList;

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public void setMovieDate(String movieDate) {
        this.movieDate = movieDate;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setMovieTime(Integer movieTime) {
        this.movieTime = movieTime;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }


}
