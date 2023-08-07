package com.example.my.domain.todo.controller;

import com.example.my.common.dto.LoginUserDTO;
import com.example.my.common.exception.InvalidSessionException;
import com.example.my.domain.todo.dto.ReqTodoTableInsertDTO;
import com.example.my.domain.todo.dto.ReqTodoTableUpdateDoneYnDTO;
import com.example.my.domain.todo.service.TodoServiceApiV1;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/todo")
public class TodoControllerApiV1 {

    private final TodoServiceApiV1 todoServiceApiV1;

    @GetMapping
    public ResponseEntity<?> getTodoTableData(HttpSession session) {
        return todoServiceApiV1.getTodoTableData(getLoginUserDTO(session));
    }

    @PostMapping
    public ResponseEntity<?> insertTodoTableData(
            @Valid @RequestBody ReqTodoTableInsertDTO dto,
            HttpSession session
    ) {
        return todoServiceApiV1.insertTodoTableData(dto, getLoginUserDTO(session));
    }

    @PutMapping("/{todoIdx}")
    public ResponseEntity<?> updateTodoTableData(
            @PathVariable Long todoIdx,
            @Valid @RequestBody ReqTodoTableUpdateDoneYnDTO dto,
            HttpSession session
    ) {
        return todoServiceApiV1.updateTodoTableData(todoIdx, dto, getLoginUserDTO(session));
    }

    @DeleteMapping("/{todoIdx}")
    public ResponseEntity<?> deleteTodoTableData(
            @PathVariable Long todoIdx,
            HttpSession session
    ) {
        return todoServiceApiV1.deleteTodoTableData(todoIdx, getLoginUserDTO(session));
    }

    private static LoginUserDTO getLoginUserDTO(HttpSession session) {
        if (session.getAttribute("loginUserDTO") == null) {
            throw new InvalidSessionException();
        }
        return (LoginUserDTO) session.getAttribute("loginUserDTO");
    }

}
