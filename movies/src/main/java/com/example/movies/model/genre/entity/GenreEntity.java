package com.example.movies.model.genre.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="GENRE")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idx", callSuper = false) // equals 로 객체 비교할때 idx로만 비교한다는 뜻.
public class GenreEntity {
    
    @Id
    
    @Column(name = "idx",nullable = false, unique = true)
    private Long idx;

    @Column(name = "genre_name", nullable = false, unique = true)
    private String genreName;
}
