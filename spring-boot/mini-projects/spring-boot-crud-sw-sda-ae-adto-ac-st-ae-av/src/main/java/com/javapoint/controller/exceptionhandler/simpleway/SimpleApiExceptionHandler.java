package com.javapoint.controller.exceptionhandler.simpleway;

import com.javapoint.service.exception.MyBusinessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;

@ControllerAdvice
public class SimpleApiExceptionHandler extends ResponseEntityExceptionHandler {

//    @ExceptionHandler(NameAlreadyBoundException.class)
//    public ResponseEntity<Object> handleNegocio(NameAlreadyBoundException ex, WebRequest request) {
//        HttpStatus status = HttpStatus.BAD_REQUEST;
//        return handleExceptionInternal(ex, "Book already registered.", new HttpHeaders(), status, request);
//    }


    @ExceptionHandler(MyBusinessException.class)
    public ResponseEntity<Object> handleNegocio( MyBusinessException ex, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        Problem problem = new Problem();
        problem.setDateTime(OffsetDateTime.now());
        problem.setStatus(status.value());
        problem.setTitle(ex.getMessage());

        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

}
