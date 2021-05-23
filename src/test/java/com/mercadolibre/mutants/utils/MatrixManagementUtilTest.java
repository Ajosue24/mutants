package com.mercadolibre.mutants.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class MatrixManagementUtilTest {

    @Test
    void parseArrayToMatrix() {
        var matrix = MatrixManagementUtil.parseArrayToMatrix(ConstantsTest.HUMAN_DNA);
        assertArrayEquals(matrix, ConstantsTest.HUMAN_DNA_MATRIX);
    }

    @Test
    void parseArrayToMatrixInvalidMatrix() {
        var matrix = MatrixManagementUtil.parseArrayToMatrix(ConstantsTest.INVALID_MATRIX);
        assertNull(matrix);
    }

    @Test
    void parseArrayToMatrixInvalidNullMatrix() {
        var matrix = MatrixManagementUtil.parseArrayToMatrix(ConstantsTest.INVALID_MATRIX_NULL);
        assertNull(matrix);
    }

    @Test
    void getAllRowCombinations() {
        var matrix = MatrixManagementUtil.getRowsListFromMatrix(ConstantsTest.MUTANT_ROW_COMBINATION_DNA_MATRIX);
        assertEquals(matrix, ConstantsTest.MUTANT_ROW_COMBINATION_DNA_MATRIX_TO_EXPECTED_COLLECTIONS);
    }

    @Test
    void getAllColumnCombinations() {
        var matrix = MatrixManagementUtil.getColumnsListFromMatrix(ConstantsTest.MUTANT_COLUMN_DNA_MATRIX);
        assertEquals(matrix, ConstantsTest.MUTANT_COLUMN_DNA_MATRIX_TO_EXPECTED_COLLECTIONS);
    }

    @Test
    void getAllObliqueCombinations() {
        var matrix = MatrixManagementUtil.getAllCombinationOblique(ConstantsTest.MUTANT_OBLIQUE_DNA_MATRIX);
        assertEquals(matrix, ConstantsTest.MUTANT_OBLIQUE_DNA_MATRIX_TO_EXPECTED_COLLECTIONS);
    }


}
