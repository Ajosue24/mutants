package com.mercadolibre.mutants.service.impl;

import com.mercadolibre.mutants.configuration.DNAValidatorProperties;
import com.mercadolibre.mutants.exception.DNAValidationException;
import com.mercadolibre.mutants.model.dto.HumanDNARequestDTO;
import com.mercadolibre.mutants.repository.service.RecordsDNAService;
import com.mercadolibre.mutants.service.HumanDNAValidationService;
import com.mercadolibre.mutants.utils.BusinessMessages;
import com.mercadolibre.mutants.utils.ConstantsTest;
import com.mercadolibre.mutants.utils.DNAValidatorUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class HumanDNAValidationImplTest {


    @Autowired
    private HumanDNAValidationService humanDNAValidationService;

    @MockBean
    private DNAValidatorUtil dnaValidatorUtil;

    @MockBean
    private RecordsDNAService recordsDNAService;

    @MockBean
    private DNAValidatorProperties dnaValidatorProperties;


    @Test
    void dnaWasNotValidated() {
        var humanDNARequestDTO = new HumanDNARequestDTO(ConstantsTest.INVALID_MATRIX);
        when(dnaValidatorUtil.validateIfDNAIsValidToCheck(humanDNARequestDTO.getDna())).thenReturn(false);
        var dnaValidationException = assertThrows(DNAValidationException.class, () -> humanDNAValidationService.isMutant(humanDNARequestDTO));
        assertEquals(BusinessMessages.DNA_WAS_NOT_VALIDATED.message(), dnaValidationException.getMessage());
    }

    @Test
    void validateIfDNAisValid() {
        var humanDNARequestDTO = new HumanDNARequestDTO(ConstantsTest.DNA_ARRAY_INVALID_CHAR);
        when(dnaValidatorUtil.validateIfDNAIsValidToCheck(humanDNARequestDTO.getDna())).thenReturn(true);
        when(dnaValidatorUtil.validateIfIsValidDNA(ConstantsTest.DNA_MATRIX_INVALID_CHAR)).thenReturn(false);
        var dnaValidationException = assertThrows(DNAValidationException.class, () -> humanDNAValidationService.isMutant(humanDNARequestDTO));
        assertEquals(BusinessMessages.DNA_HAS_INVALID_CHARACTERS.message(), dnaValidationException.getMessage());
    }


    @Test
    void validateIfMutant() {
        when(dnaValidatorProperties.getDnaCantSequence()).thenReturn(ConstantsTest.MUTANT_DNA_CANT_SEQUENCE);
        when(dnaValidatorProperties.getDnaCantSameLetters()).thenReturn(ConstantsTest.MUTANT_DNA_CANT_SAME_LETTERS);
        assertFalse(humanDNAValidationService.validateIfMutant(ConstantsTest.HUMAN_DNA_MATRIX));
        assertTrue(humanDNAValidationService.validateIfMutant(ConstantsTest.MUTANT_ROW_COMBINATION_DNA_MATRIX));
        assertTrue(humanDNAValidationService.validateIfMutant(ConstantsTest.MUTANT_COLUMN_DNA_MATRIX));
        assertTrue(humanDNAValidationService.validateIfMutant(ConstantsTest.MUTANT_OBLIQUE_DNA_MATRIX));
    }


}
