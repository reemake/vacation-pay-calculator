package ru.neoflex.paycalculator.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class IncorrectSalaryExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(IncorrectSalaryException.class)
    protected ResponseEntity<SomeException> handleThereIsNoSuchUserException() {
        return new ResponseEntity<>(new SomeException("Stated salary is incorrect"), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @Data
    @AllArgsConstructor
    private static class SomeException {
        private String message;
    }
}
