package com.mercadolibre.mutants.configuration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

class DNAValidatorPropertiesTest {

    @Test
    void validatorPropertiesTest() {
        var properties = new DNAValidatorProperties();
        assertNull(properties.getDnaValidChars());
        assertNull(properties.getDnaCantSameLetters());
        assertNull(properties.getDnaCantSequence());
    }
}
