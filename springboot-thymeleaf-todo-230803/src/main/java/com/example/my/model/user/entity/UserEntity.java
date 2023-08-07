package com.example.my.model.user.entity;

import com.example.my.model.todo.entity.TodoEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "`USER`")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idx", callSuper = false)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx", nullable = false, unique = true)
    private Long idx;

    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "create_date" , nullable = false)
    private LocalDateTime createDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @Column(name = "delete_date")
    private LocalDateTime deleteDate;

    @OneToMany(mappedBy = "userEntity", fetch = FetchType.EAGER)
    private List<UserRoleEntity> userRoleEntityList;

    @OneToMany(mappedBy = "userEntity", fetch = FetchType.LAZY)
    private List<TodoEntity> todoEntityList;
}
