package ru.finan.finserver.exceptions.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.finan.finserver.exceptions.model.ErrorResponse;
import ru.finan.finserver.exceptions.model.PasswordException;

@Slf4j
@RestControllerAdvice
public class ErrorHandle {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponse handlePasswordException (final PasswordException e) {
        log.debug("Произошла ошибка {}", e.getMessage());
        return new ErrorResponse(e.getMessage());
    }
}
