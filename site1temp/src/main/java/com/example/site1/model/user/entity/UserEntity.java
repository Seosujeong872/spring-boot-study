package com.example.site1.model.user.entity;

import java.util.List;

import com.example.site1.model.post.entity.PostEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx", nullable = false, unique = true)
    private Integer idx;

    @Column(name = "id", nullable = false)
    private String id;


    @Column(name="password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "userEntity")
    private List<PostEntity> postEntityList;

    @Override
    public String toString() {
        return "UserEntity [idx=" + idx + ", id=" + id + "]";
    }

   

    
}
