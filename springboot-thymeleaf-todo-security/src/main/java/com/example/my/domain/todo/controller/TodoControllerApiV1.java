package com.example.my.domain.todo.controller;

import com.example.my.common.dto.LoginUserDTO;
import com.example.my.common.exception.InvalidSessionException;
import com.example.my.config.security.auth.CustomUserDetails;
import com.example.my.domain.todo.dto.ReqTodoTableInsertDTO;
import com.example.my.domain.todo.dto.ReqTodoTableUpdateDoneYnDTO;
import com.example.my.domain.todo.service.TodoServiceApiV1;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/todo")
public class TodoControllerApiV1 {

    private final TodoServiceApiV1 todoServiceApiV1;

    @GetMapping
    public ResponseEntity<?> getTodoTableData(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
        return todoServiceApiV1.getTodoTableData(customUserDetails.getLoginUserDTO());
    }

    @PostMapping
    public ResponseEntity<?> insertTodoTableData(
            @Valid @RequestBody ReqTodoTableInsertDTO dto,
            @AuthenticationPrincipal CustomUserDetails customUserDetails
    ) {
        return todoServiceApiV1.insertTodoTableData(dto, customUserDetails.getLoginUserDTO());
    }

    @PutMapping("/{todoIdx}")
    public ResponseEntity<?> updateTodoTableData(
            @PathVariable Long todoIdx,
            @Valid @RequestBody ReqTodoTableUpdateDoneYnDTO dto,
            @AuthenticationPrincipal CustomUserDetails customUserDetails
    ) {
        return todoServiceApiV1.updateTodoTableData(todoIdx, dto, customUserDetails.getLoginUserDTO());
    }

    @DeleteMapping("/{todoIdx}")
    public ResponseEntity<?> deleteTodoTableData(
            @PathVariable Long todoIdx,
            @AuthenticationPrincipal CustomUserDetails customUserDetails
    ) {
        return todoServiceApiV1.deleteTodoTableData(todoIdx, customUserDetails.getLoginUserDTO());
    }

}
