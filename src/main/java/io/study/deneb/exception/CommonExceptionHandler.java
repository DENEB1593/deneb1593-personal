package io.study.deneb.exception;

import io.study.deneb.controller.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(CommonExceptionHandler.class);

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<CommonResponse> handleArgumentException(IllegalArgumentException e) {
        log.warn("illegal argument exception occurred : {}", e.getMessage(), e);
        return setResponse(HttpStatus.BAD_REQUEST, e);
    }

    private static ResponseEntity<CommonResponse> setResponse(HttpStatus status, Exception e) {

        CommonResponse body = CommonResponse.error(e.getMessage());

        return ResponseEntity
                .status(status)
                .body(body);
    }


}