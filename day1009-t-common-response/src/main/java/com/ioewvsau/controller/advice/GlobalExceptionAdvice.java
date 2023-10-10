package com.ioewvsau.controller.advice;

import com.ioewvsau.util.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public R exception(Exception e) {
        return R.fail(e.getMessage());
    }
}
