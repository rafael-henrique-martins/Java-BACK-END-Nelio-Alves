package com.rafael.cursomc.resources.exception;

import com.rafael.cursomc.services.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StardardError> objectNotFound(ObjectNotFoundException e,
                                                        HttpServletRequest request){
        StardardError err = new StardardError(HttpStatus.NOT_FOUND.value(),
                e.getMessage(), System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);

    }
}
