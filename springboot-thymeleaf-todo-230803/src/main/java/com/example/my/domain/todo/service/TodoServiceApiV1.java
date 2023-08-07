package com.example.my.domain.todo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.my.common.dto.LoginUserDTO;
import com.example.my.common.dto.ResponseDTO;
import com.example.my.common.exception.BadRequestException;
import com.example.my.domain.todo.dto.ReqTodoTableInsertDTO;
import com.example.my.domain.todo.dto.ReqTodoTableUpdateDoneYnDTO;
import com.example.my.domain.todo.dto.ResTodoTableDTO;
import com.example.my.model.todo.entity.TodoEntity;
import com.example.my.model.todo.repository.TodoRepository;
import com.example.my.model.user.entity.UserEntity;
import com.example.my.model.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoServiceApiV1 {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    public ResponseEntity<?> getTodoTableData(LoginUserDTO loginUserDTO) {

        List<TodoEntity> todoEntityList = todoRepository
                .findByUserEntity_IdxAndDeleteDateIsNull(loginUserDTO.getUser().getIdx());

        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .code(0)
                        .message("할 일 목록 조회에 성공하였습니다.")
                        .data(ResTodoTableDTO.of(todoEntityList))
                        .build(),
                HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<?> insertTodoTableData(ReqTodoTableInsertDTO dto, LoginUserDTO loginUserDTO) {

        if (dto == null || dto.getTodo() == null || dto.getTodo().getContent() == null
                || dto.getTodo().getContent().trim().length() == 0) {
            throw new BadRequestException("할 일을 입력해주세요.");
        }

        Optional<UserEntity> userEntityOptional = userRepository
                .findByIdxAndDeleteDateIsNull(loginUserDTO.getUser().getIdx());

        if (userEntityOptional.isEmpty()) {
            throw new BadRequestException("존재하지 않는 사용자입니다.");
        }

        TodoEntity todoEntity = TodoEntity.builder()
                .userEntity(userEntityOptional.get())
                .content(dto.getTodo().getContent())
                .doneYn("N")
                .createDate(LocalDateTime.now())
                .build();

        todoRepository.save(todoEntity);

        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .code(0)
                        .message("할 일 추가에 성공하였습니다.")
                        .build(),
                HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<?> updateTodoTableData(Long todoIdx, ReqTodoTableUpdateDoneYnDTO dto,
            LoginUserDTO loginUserDTO) {

        Optional<TodoEntity> todoEntityOptional = todoRepository.findByIdxAndDeleteDateIsNull(todoIdx);

        if (todoEntityOptional.isEmpty()) {
            throw new BadRequestException("존재하지 않는 할 일입니다.");
        }

        TodoEntity todoEntity = todoEntityOptional.get();

        if (!todoEntity.getUserEntity().getIdx().equals(loginUserDTO.getUser().getIdx())) {
            throw new BadRequestException("권한이 없습니다.");
        }

        todoEntity.setDoneYn(dto.getTodo().getDoneYn());

        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .code(0)
                        .message("할 일 수정에 성공하였습니다.")
                        .build(),
                HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<?> deleteTodoTableData(Long todoIdx, LoginUserDTO loginUserDTO) {

        Optional<TodoEntity> todoEntityOptional = todoRepository.findByIdxAndDeleteDateIsNull(todoIdx);

        if (todoEntityOptional.isEmpty()) {
            throw new BadRequestException("존재하지 않는 할 일입니다.");
        }

        TodoEntity todoEntity = todoEntityOptional.get();

        if (!todoEntity.getUserEntity().getIdx().equals(loginUserDTO.getUser().getIdx())) {
            throw new BadRequestException("권한이 없습니다.");
        }

        todoEntity.setDeleteDate(LocalDateTime.now());

        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .code(0)
                        .message("할 일 삭제에 성공하였습니다.")
                        .build(),
                HttpStatus.OK);
    }

}
