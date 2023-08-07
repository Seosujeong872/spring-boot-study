package com.example.my.model.user.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "USER_ROLE")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idx", callSuper = false)
public class UserRoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx", nullable = false, unique = true)
    private Integer idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx", referencedColumnName = "idx", updatable = false, nullable = false)
    private UserEntity userEntity;

    @Column(name = "role")
    private String role;

    @Column(name = "create_date")
    private LocalDateTime createDate;
}
