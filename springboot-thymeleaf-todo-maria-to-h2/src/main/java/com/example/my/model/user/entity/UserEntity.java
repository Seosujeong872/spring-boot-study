package com.example.my.model.user.entity;

import com.example.my.model.todo.entity.TodoEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.Where;
import org.hibernate.annotations.WhereJoinTable;

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
    @Where(clause = "delete_date IS NULL") // 조건에 맞는 엔티티만 가져오기
    private List<TodoEntity> todoEntityList;
}
