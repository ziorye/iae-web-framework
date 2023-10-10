package com.ioewvsau.controller.advice;

import com.ioewvsau.exception.BusinessException;
import com.ioewvsau.exception.SystemException;
import com.ioewvsau.util.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionAdvice {
    @ExceptionHandler(BusinessException.class)
    public R be(BusinessException be) {
        // 记录日志
        // ...
        return R.fail(be.getMessage() + "【日志已记录...】");
    }

    @ExceptionHandler(SystemException.class)
    public R se(SystemException se) {
        // 记录日志
        // 发送邮件
        // ...
        return R.fail(se.getMessage() + "【日志已记录 + 邮件已发送...】");
    }

    @ExceptionHandler(Exception.class)
    public R exception(Exception e) {
        return R.fail(e.getMessage());
    }
}
