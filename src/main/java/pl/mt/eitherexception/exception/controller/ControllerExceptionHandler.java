package pl.mt.eitherexception.exception.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class ControllerExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<DivideResult> handleArithmeticException(ArithmeticException exception) {
        return ResponseEntity.badRequest().body(DivideResult.error(exception.getMessage()));
    }
}
