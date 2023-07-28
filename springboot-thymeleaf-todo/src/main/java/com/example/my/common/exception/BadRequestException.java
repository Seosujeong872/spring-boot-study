package com.example.my.common.exception;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String message){
        super(message); // 조상클래스 초기화?

    }
    public BadRequestException(){
        super("잘못된 요청입니다.");
    }
    
}
