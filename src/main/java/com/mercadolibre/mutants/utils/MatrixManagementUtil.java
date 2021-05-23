package com.mercadolibre.mutants.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class MatrixManagementUtil {

    /**
     * from String array get matrix
     *
     * @param dnaArray userInput
     * @return matrix
     */
    public static String[][] parseArrayToMatrix(String[] dnaArray) {
        try {
            int n = dnaArray.length;
            int m = dnaArray[0].length();
            String[][] matrix = new String[n][m];
            var matrixObj = new Object() {
                int rows = 0, columns = 0;
            };
            Arrays.stream(dnaArray).forEach(row -> {
                        row.chars().forEachOrdered(eachRowElement -> matrix[matrixObj.rows][matrixObj.columns++] = String.valueOf((char) eachRowElement));
                        matrixObj.rows++;
                        matrixObj.columns = 0;
                    }
            );
            return matrix;
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            return null;
        }
    }

    /**
     * looks like getColumnsListFromMatrix but iterator is per rows
     *
     * @param dnaMatrix org matrix
     * @return list of rows
     */
    public static List<List<String>> getRowsListFromMatrix(String[][] dnaMatrix) {
        int cantRow = dnaMatrix.length;
        List<List<String>> rows = new ArrayList<>();
        var countRowsObj = new Object() {
            int count = 0;
        };
        Arrays.stream(dnaMatrix).takeWhile((obj) -> countRowsObj.count < cantRow).forEachOrdered(row -> {
            rows.add(Arrays.asList(row));
            countRowsObj.count++;
        });
        return rows;
    }

    /**
     * looks like getRowsListFromMatrix but iterator is per columns
     *
     * @param dnaMatrix original matrix
     * @return list of columns
     */
    public static List<List<String>> getColumnsListFromMatrix(String[][] dnaMatrix) {
        int cantColumns = dnaMatrix[0].length;
        List<List<String>> columns = new ArrayList<>();
        var countColumnsObj = new Object() {
            int count = 0;
        };
        Arrays.stream(dnaMatrix).takeWhile((obj) -> countColumnsObj.count < cantColumns).forEachOrdered(column -> {
            columns.add(Arrays.stream(dnaMatrix).map(o -> o[countColumnsObj.count]).collect(Collectors.toList()));
            countColumnsObj.count++;
        });
        return columns;
    }

    /**
     * @param dnaMatrix original matrix
     * @return only oblique arrays
     */
    public static List<List<String>> getAllCombinationOblique(String[][] dnaMatrix) {
        int cantRow = dnaMatrix.length;
        var countObj = new Object() {
            int rows = 0, columns = 0;
        };
        List<String> leftToRightOblique = new ArrayList<>();
        List<String> rightToLeftOblique = new ArrayList<>();
        Arrays.stream(dnaMatrix).forEach(row -> {
            Arrays.stream(row).forEachOrdered(elements -> {
                if (countObj.rows == countObj.columns) {
                    leftToRightOblique.add(elements);
                }
                if ((countObj.rows + countObj.columns) == cantRow - 1) {
                    rightToLeftOblique.add(elements);
                }
                countObj.columns++;
            });
            countObj.rows++;
            countObj.columns = 0;
        });
        return Arrays.asList(leftToRightOblique, rightToLeftOblique);
    }

    /**
     * Validate all combinations and determinate if person is human or mutant
     *
     * @param allRowElement      matrix become into collections
     * @param dnaCantSameLetters cant of combinations give per parameters
     * @return cant of combinations in Integer
     */
    public static Integer validateAllCombinations(List<List<String>> allRowElement, Integer dnaCantSameLetters) {

        var rowCombinationObj = new Object() {
            String previousChar = allRowElement.stream().findFirst().get().stream().findFirst().get();
            int count = 0;
            int cantComb = 0;
        };
        allRowElement.forEach(row -> row.forEach(elements -> {
            if (rowCombinationObj.previousChar.equals(elements)) {
                rowCombinationObj.count++;
                if (rowCombinationObj.count >= dnaCantSameLetters) {
                    rowCombinationObj.cantComb++;
                    rowCombinationObj.count = 0;
                }
            } else {
                rowCombinationObj.previousChar = elements;
                rowCombinationObj.count = 0;
            }
        }));
        return rowCombinationObj.cantComb;
    }



}
