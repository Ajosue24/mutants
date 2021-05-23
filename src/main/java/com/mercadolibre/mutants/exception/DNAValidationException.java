package com.mercadolibre.mutants.exception;

public class DNAValidationException extends RuntimeException {

        private static final long serialVersionUID = 1L;

    public DNAValidationException(String message) {
        super(message);
    }
}
