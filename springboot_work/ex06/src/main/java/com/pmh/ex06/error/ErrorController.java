package com.pmh.ex06.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(BizException.class)
    public ResponseEntity<String> mException(BizException e){
        return ResponseEntity
                .status(e.getErrorCode().getHttpStatus())
                .body(e.toString());
    }
}
