package com.mercadolibre.mutants.utils;

import com.mercadolibre.mutants.configuration.DNAValidatorProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
class DNAValidatorUtilTest {

    @Autowired
    private DNAValidatorUtil dnaValidatorUtil;

    @MockBean
    private DNAValidatorProperties dnaValidatorProperties;

    @Test
    void invalidCharReadingDNA() {
        when(dnaValidatorProperties.getDnaValidChars()).thenReturn(ConstantsTest.DNA_VALID_CHAR);
        var isValid = dnaValidatorUtil.validateIfIsValidDNA(ConstantsTest.DNA_MATRIX_INVALID_CHAR);
        assertFalse(isValid);
    }

    @Test
    void validCharReadingDNA() {
        when(dnaValidatorProperties.getDnaValidChars()).thenReturn(ConstantsTest.DNA_VALID_CHAR);
        var isValid = dnaValidatorUtil.validateIfIsValidDNA(ConstantsTest.DNA_MATRIX_VALID_CHAR);
        assertTrue(isValid);
    }

    @Test
    void arrayIsValidToCheck() {
        when(dnaValidatorProperties.getDnaCantSameLetters()).thenReturn(ConstantsTest.MUTANT_DNA_CANT_SAME_LETTERS);
        var isValid = dnaValidatorUtil.validateIfDNAIsValidToCheck(ConstantsTest.VALID_ARRAY_TO_VALIDATE);
        assertTrue(isValid);
    }

    @Test
    void arrayIsInvalidToCheck() {
        when(dnaValidatorProperties.getDnaCantSameLetters()).thenReturn(ConstantsTest.MUTANT_DNA_CANT_SAME_LETTERS);
        var isValid = dnaValidatorUtil.validateIfDNAIsValidToCheck(ConstantsTest.INVALID_ARRAY_TO_VALIDATE);
        assertFalse(isValid);
    }

}
