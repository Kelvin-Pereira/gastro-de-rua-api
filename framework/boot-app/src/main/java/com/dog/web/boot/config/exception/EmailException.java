package com.dog.web.boot.config.exception;

import lombok.Getter;

@Getter
public class EmailException extends RuntimeException {

    private final int code;

    public EmailException(String message, int statusCode) {
        super(message);
        this.code = statusCode;
    }

    public static EmailException emailNaoEncontrado() {
        return new EmailException("EMAIL_NOT_FOUND", 401);
    }

}
