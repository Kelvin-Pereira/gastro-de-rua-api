package com.dog.web.boot.config.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(EmailException.class)
    public ResponseError httpExceptionHandler(EmailException e) {
        ResponseError responseError = new ResponseError();
        responseError.setCode(e.getCode());
        responseError.setDescription(e.getMessage());
        return responseError;
    }

}
