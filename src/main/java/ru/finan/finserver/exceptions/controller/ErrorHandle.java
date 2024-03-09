package ru.finan.finserver.exceptions.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.finan.finserver.exceptions.model.ErrorResponse;
import ru.finan.finserver.exceptions.model.UserNameNotFoundException;
import ru.finan.finserver.exceptions.model.UserNotFoundException;

@Slf4j
@RestControllerAdvice
public class ErrorHandle {

    @ExceptionHandler({UserNotFoundException.class, UserNameNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleUserNotFoundException (final Exception e) {
        log.debug("Произошла ошибка {}", e.getMessage());
        return new ErrorResponse(e.getMessage());
    }
}
