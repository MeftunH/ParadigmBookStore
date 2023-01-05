package com.paradigmbookstore.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler
    public String handleException(Exception e) {
        return e.getMessage();
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
      Map<String,String> errors = new HashMap<>();
      ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
          errors.put(fieldError.getField(),fieldError.getDefaultMessage());
      });
        return ResponseEntity.badRequest()
                .body(errors);
    }

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<?> handleException(GenericException genericException)
    {
        Map<String,Object> errors = new HashMap<>();
        errors.put("message",genericException.getMessage());
        errors.put("status",genericException.getHttpStatus());

        return   ResponseEntity
                .status(genericException.getHttpStatus())
                .body(errors);
    }
 }
