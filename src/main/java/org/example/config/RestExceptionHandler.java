package org.example.config;

import org.example.models.RestValidationError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

public class RestExceptionHandler {

    Logger log = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<RestValidationError>> handler(MethodArgumentNotValidException e){
        log.error("erro de validação");
        List<RestValidationError> errors = new ArrayList<>();
        e.getFieldErrors().forEach(v -> errors.add( new RestValidationError(v.getField(), v.getDefaultMessage())));
        return ResponseEntity.badRequest().body(errors);
    }
}
