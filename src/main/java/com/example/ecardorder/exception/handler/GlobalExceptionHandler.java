package com.example.ecardorder.exception.handler;


import com.example.ecardorder.exception.CardNotFoundException;
import com.example.ecardorder.exception.model.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CardNotFoundException.class)
    public ErrorResponse handleCardNotFoundException(CardNotFoundException exception,
                                                     HttpServletRequest httpServletRequest) {
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .timestamp(LocalDateTime.now())
                .path(httpServletRequest.getServletPath())
                .build();

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception, HttpServletRequest httpServletRequest) {

        Map<String, String> errors = new HashMap<>();

        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ErrorResponse.builder()
                .errors(errors)
                .message("Validation failed")
                .timestamp(LocalDateTime.now())
                .path(httpServletRequest.getServletPath())
                .build();

    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleException(Exception exception,
                                         HttpServletRequest httpServletRequest) {
        return ErrorResponse.builder()
                .message("Something went wrong")
                .timestamp(LocalDateTime.now())
                .path(httpServletRequest.getServletPath())
                .build();

    }

}
