package com.mercadolibre.mutants.controller;

import com.mercadolibre.mutants.controller.security.ErrorHandlerController;
import com.mercadolibre.mutants.exception.DNAValidationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ErrorHandlerControllerTest {

    @Test
    void ErrorHandlerControllerException() {
        var errorHandler = new ErrorHandlerController();
        assertNotNull(errorHandler.dnaValidationHandlerError(new DNAValidationException("test")));
    }
}
