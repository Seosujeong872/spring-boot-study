package com.example.movies.model.user.entity;

import com.example.movies.model.genre.entity.GenreEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "`user_genre_mapping`")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserGenreEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx", nullable = false , unique = true)
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "user_idx", referencedColumnName = "idx", nullable = false)
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "genre_idx", referencedColumnName = "idx", nullable = false)
    private GenreEntity genreEntity;
}
