package com.example.my.model.todo.repository;

import com.example.my.model.todo.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
    List<TodoEntity> findByDeleteDateIsNull();

    List<TodoEntity> findByUserEntity_IdxAndDeleteDateIsNull(Long userIdx);
    List<TodoEntity> findByUserEntity_IdxAndDeleteDateIsNullOrderByIdxDesc(Long userIdx);

    Optional<TodoEntity> findByIdx(Long idx);
    Optional<TodoEntity> findByIdxAndDeleteDateIsNull(Long idx);

}
