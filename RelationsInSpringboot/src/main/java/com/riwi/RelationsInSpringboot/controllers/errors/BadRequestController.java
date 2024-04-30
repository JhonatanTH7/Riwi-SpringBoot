package com.riwi.RelationsInSpringboot.controllers.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.riwi.RelationsInSpringboot.utils.dto.errors.BaseErrorResponse;
import com.riwi.RelationsInSpringboot.utils.dto.errors.ErrorResponse;
import com.riwi.RelationsInSpringboot.utils.exceptions.IdNotFoundException;

@RestControllerAdvice
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestController {
    @ExceptionHandler(IdNotFoundException.class)
    public BaseErrorResponse handleIdNotFound(IdNotFoundException exception) {
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .status(HttpStatus.BAD_REQUEST.name())
                .code(HttpStatus.BAD_REQUEST.value()).build();
    }
}
