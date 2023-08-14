package com.example.movies.model.movie.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="`movie`")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx", nullable = false, unique = true)
    private Long idx;

    @Column(name = "movie_name" ,nullable = false)
    private String movie_name;

    @Column(name = "poster" ,nullable = false)
    private String poster;

    @Column(name = "movie_date" ,nullable = false)
    private String movie_date;

    @Column(name = "country" ,nullable = false)
    private String country;

    @Column(name = "grade" ,nullable = false)
    private String grade;

    @Column(name = "movie_time" ,nullable = false)
    private Integer movie_time;

    @Column(name = "summary" ,nullable = false)
    private String summary;

    @Column(name = "movie_url")
    private String movie_url;



}
