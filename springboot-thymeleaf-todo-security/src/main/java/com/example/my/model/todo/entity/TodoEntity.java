package com.example.my.model.todo.entity;

import com.example.my.model.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TODO")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idx", callSuper = false)
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx", nullable = false, unique = true)
    private Long idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx", referencedColumnName = "idx", updatable = false, nullable = false)
    private UserEntity userEntity;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "done_yn" , nullable = false)
    private Character doneYn;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @Column(name = "delete_date")
    private LocalDateTime deleteDate;

    public void setDoneYn(Character doneYn) {
        this.doneYn = doneYn;
        this.updateDate = LocalDateTime.now();
    }

    public void setDeleteDate(LocalDateTime deleteDate) {
        this.deleteDate = deleteDate;
    }
}
