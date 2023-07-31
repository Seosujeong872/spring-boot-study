package com.example.site2.model.user.entity;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "`user`")
@AllArgsConstructor // 생성자를 대신 만들어준다.
@NoArgsConstructor // 매개변수를 하나도 안 받는 생성자
@Getter
@ToString
public class UserEntity {

    @Id // 프라이머리키에 붙인다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment 쓰기 위해
    @Column(name="idx", nullable = false, unique = true)
    private Long idx;

    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Column(name = "password", nullable = false)
    private String password;

    // public Long getIdx() {
    //     return idx;
    // }

    // public String getId() {
    //     return id;
    // }

    // public String getPassword() {
    //     return password;
    // }

    // public UserEntity(Long idx, String id, String password) {
    //     this.idx = idx;
    //     this.id = id;
    //     this.password = password;
    // }

    // public UserEntity(){
     
    // }

    

    
}
