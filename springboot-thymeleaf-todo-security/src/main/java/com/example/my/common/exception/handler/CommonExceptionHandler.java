package com.example.my.common.exception.handler;

import com.example.my.common.dto.ResponseDTO;
import com.example.my.common.exception.BadRequestException;
import com.example.my.common.exception.EntityNotFoundException;
import com.example.my.common.exception.InvalidSessionException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(BindException.class)
    public HttpEntity<?> handleBindException(BindException exception){
        Map<String,String> errorMap = new HashMap<>();

        exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        });

        return new ResponseEntity<>(
                ResponseDTO.builder()
                .code(1)
                .message("요청 데이터가 유효하지 않습니다.")
                .data(errorMap)
                .build(),
                HttpStatus.BAD_REQUEST
        );

    }

    @ExceptionHandler(EntityNotFoundException.class)
    public HttpEntity<?> handleEntityNotFoundException(){
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .code(1)
                        .message("요청 데이터가 유효하지 않습니다.")
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(InvalidSessionException.class)
    public HttpEntity<?> handleInvalidSessionException(Exception exception){
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .code(1)
                        .message("로그인이 필요합니다.")
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(BadRequestException.class)
    public HttpEntity<?> handleBadRequestException(Exception exception){

        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .code(1)
                        .message(exception.getMessage())
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(Exception.class)
    public HttpEntity<?> handleException(Exception exception){
        String message = "에러가 발생했습니다. 관리자에게 문의하세요.";

        if (exception.getMessage() != null && !exception.getMessage().equals("")){
            message = exception.getMessage();
        }

        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .code(1)
                        .message(message)
                        .build(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
