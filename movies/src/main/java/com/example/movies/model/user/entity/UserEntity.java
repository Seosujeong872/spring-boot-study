package com.example.movies.model.user.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="`USER`")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idx", callSuper = false) // equals 로 객체 비교할때 idx로만 비교한다는 뜻.
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx", nullable = false, unique = true)
    private Long idx;
    
    @Column(name = "id", nullable = false, unique = true)
    private String id;
    
    @Column(name = "nickname", nullable = false, unique = true)
    private String nickname;
    
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name ="birth",nullable = false )
    private LocalDate birth;

    @Column(name = "role",nullable = false)
    private String role;
     
}
