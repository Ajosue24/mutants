package com.mercadolibre.mutants.utils;

import com.mercadolibre.mutants.exception.DNAValidationException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class MatrixManagementUtilTest {

    @Test
    void parseArrayToMatrix() {
        var matrix = MatrixManagementUtil.parseArrayToMatrix(ConstantsTest.HUMAN_DNA);
        assertArrayEquals(ConstantsTest.HUMAN_DNA_MATRIX,matrix);
    }

    @Test
    void parseArrayToMatrixInvalidMatrixOrNullValues() {
        var dnaValidationInvalidMatrix = assertThrows(DNAValidationException.class, () -> MatrixManagementUtil.parseArrayToMatrix(ConstantsTest.INVALID_MATRIX));
        var dnaValidationNull = assertThrows(DNAValidationException.class, () -> MatrixManagementUtil.parseArrayToMatrix(ConstantsTest.INVALID_MATRIX_NULL));
        assertEquals(BusinessMessages.DNA_IS_INVALID.message(), dnaValidationInvalidMatrix.getMessage());
        assertEquals(BusinessMessages.DNA_IS_INVALID.message(), dnaValidationNull.getMessage());
    }

    @Test
    void getAllRowCombinations() {
        var matrix = MatrixManagementUtil.getRowsListFromMatrix(ConstantsTest.MUTANT_ROW_COMBINATION_DNA_MATRIX);
        assertEquals( ConstantsTest.MUTANT_ROW_COMBINATION_DNA_MATRIX_TO_EXPECTED_COLLECTIONS,matrix);
    }

    @Test
    void getAllColumnCombinations() {
        var matrix = MatrixManagementUtil.getColumnsListFromMatrix(ConstantsTest.MUTANT_COLUMN_DNA_MATRIX);
        assertEquals( ConstantsTest.MUTANT_COLUMN_DNA_MATRIX_TO_EXPECTED_COLLECTIONS,matrix);
    }

    @Test
    void getAllObliqueCombinations() {
        var matrix = MatrixManagementUtil.getAllCombinationOblique(ConstantsTest.MUTANT_OBLIQUE_DNA_MATRIX);
        assertEquals( ConstantsTest.MUTANT_OBLIQUE_DNA_MATRIX_TO_EXPECTED_COLLECTIONS,matrix);
    }

    @Test
    void validateAllCombinations() {
        var cantMutantCombination = MatrixManagementUtil.validateAllCombinations(ConstantsTest.MUTANT_ROW_COMBINATION_DNA_MATRIX_TO_EXPECTED_COLLECTIONS, ConstantsTest.MUTANT_DNA_CANT_SAME_LETTERS);
        var cantHumanCombination = MatrixManagementUtil.validateAllCombinations(ConstantsTest.HUMAN_DNA_MATRIX_TO_EXPECTED_COLLECTIONS, ConstantsTest.MUTANT_DNA_CANT_SAME_LETTERS);
        assertTrue(cantMutantCombination > 0);
        assertEquals(0, (int) cantHumanCombination);
    }


}
