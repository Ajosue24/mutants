package com.mercadolibre.mutants.controller.security;

import com.mercadolibre.mutants.exception.DNAValidationException;
import com.mercadolibre.mutants.model.commons.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlerController {


    @ExceptionHandler(value = DNAValidationException.class)
    public ResponseEntity<StandardResponse<Object>> dnaValidationHandlerError(DNAValidationException dnaValidationException) {
        return new ResponseEntity<>(new StandardResponse<>(dnaValidationException.getMessage(), HttpStatus.BAD_REQUEST.name(), null), HttpStatus.BAD_REQUEST);
    }

}
