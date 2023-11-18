package com.example.demo.exception;

import org.springframework.http.*;

public class TestNotFoundException extends ApiException {

    public TestNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }

}
