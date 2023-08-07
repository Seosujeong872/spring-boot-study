package com.example.my.common.exception;

public class InvalidSessionException extends RuntimeException {

    public InvalidSessionException(String message) {
        super(message);
    }

    public InvalidSessionException() {
        super("로그인이 필요합니다.");
    }

}
