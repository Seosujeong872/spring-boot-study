package com.example.my.domain.todo.controller;

import com.example.my.common.dto.LoginUserDTO;
import com.example.my.common.dto.ResponseDTO;
import com.example.my.domain.todo.dto.ReqTodoTableInsertDTO;
import com.example.my.domain.todo.dto.ReqTodoTableUpdateDoneYnDTO;
import com.example.my.domain.todo.service.TodoServiceApiV1;
import com.example.my.model.todo.entity.TodoEntity;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/todo")
public class TodoControllerApiV1 {

    private final TodoServiceApiV1 todoServiceApiV1;

    @GetMapping
    public ResponseEntity<?> getTodoTableData(HttpSession session, LoginUserDTO loginUserDTO) {
        // TODO : 서비스에서 할 일 목록 가져오기
        return todoServiceApiV1.getTodoTableData(session, loginUserDTO);
    }

    @PostMapping
    public ResponseEntity<?> insertTodoTableData(
            @Valid @RequestBody ReqTodoTableInsertDTO dto,
            HttpSession session) {
        // TODO : session에 dto가 없으면 BadRequest 처리
        LoginUserDTO loginUserDTO = (LoginUserDTO) session.getAttribute("dto");

        System.out.println(loginUserDTO);

        if (loginUserDTO == null) {
            return new ResponseEntity<>(
                    ResponseDTO.builder()
                            .code(1)
                            .message("로그인해주세요")
                            .build(),
                    HttpStatus.BAD_REQUEST);

        }
        // TODO : 서비스에서 할 일 추가하기
        return todoServiceApiV1.insertTodoTableData(dto, loginUserDTO);
    }

    @PutMapping("/{todoIdx}")
    public ResponseEntity<?> updateTodoTableData(
            @PathVariable Long todoIdx,
            @RequestBody ReqTodoTableUpdateDoneYnDTO dto,
            HttpSession session) {
        // TODO : 서비스에서 할 일 완료 수정하기
        return null;
    }

    @DeleteMapping("/{todoIdx}")
    public ResponseEntity<?> deleteTodoTableData(
            @PathVariable Long todoIdx,
            HttpSession session) {
        // TODO : 서비스에서 할 일 삭제하기
        return null;
    }

}
