package com.example.own.exception;

import com.example.own.common.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 如果抛出的的是ServiceException，则调用该方法
     *
     * @param se 业务异常
     * @return Result
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public ResponseEntity<Result> handle(ServiceException se) {
        return ResponseEntity.status(se.getCode()).body(Result.error(se.getCode(), se.getMessage()));
    }

}