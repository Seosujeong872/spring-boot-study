package com.example.site1.model.post.entity;

import com.example.site1.model.user.entity.UserEntity;

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
@Table(name="post") // 디비에 있는 테이블명
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class PostEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idx" ,nullable = false,unique = true)
    private Integer idx;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name="content",nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name="user_idx",referencedColumnName = "idx", nullable = false)
    // private Integer userIdx; // null처리 하기 위해서 int 아닌 integer
    private UserEntity userEntity;
}
