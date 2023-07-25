package com.example.my.model.todo.repository;

import com.example.my.model.todo.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
    List<TodoEntity> findByDeleteDateIsNull();
    // 삭제안된 리스트 찾겠다.

    // select * 
    // from todo
    // where user_idx = ?
    // and delete_date is null;
    List<TodoEntity> findByUserEntity_IdxAndDeleteDateIsNull(Long userIdx);
    //  userentity 의 idx로 가져오겠다.
    List<TodoEntity> findByUserEntity_IdxAndDeleteDateIsNullOrderByIdxDesc(Long userIdx);

    Optional<TodoEntity> findByIdx(Long idx);
    Optional<TodoEntity> findByIdxAndDeleteDateIsNull(Long idx);

}
