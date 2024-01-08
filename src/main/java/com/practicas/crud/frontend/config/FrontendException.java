package com.practicas.crud.frontend.config;

import org.springframework.http.HttpStatus;

import java.io.Serial;

public class FrontendException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    private HttpStatus httpStatus;

    public FrontendException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public FrontendException(String message, int statusCode) {
        super(message);
        this.httpStatus = HttpStatus.valueOf(statusCode);
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String toString() {
        return "FrontendException{" +
                "httpStatus=" + httpStatus +
                '}';
    }
}
