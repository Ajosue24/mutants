package com.mercadolibre.mutants.utils;

import java.util.Arrays;
import java.util.List;

public class ConstantsTest {

    public static final String[] HUMAN_DNA = {
            "ATGCGA",
            "CAGTGC",
            "TTATTT",
            "AGACGG",
            "GCGTCA",
            "TCACTG"};
    public static final String[][] HUMAN_DNA_MATRIX = {
            {"A", "T", "G", "C", "G", "A"},
            {"C", "A", "G", "T", "G", "C"},
            {"T", "T", "A", "T", "T", "T"},
            {"A", "G", "A", "C", "G", "G"},
            {"G", "C", "G", "T", "C", "A"},
            {"T", "C", "A", "C", "T", "G"}};
    public static final List<List<String>> HUMAN_DNA_MATRIX_TO_EXPECTED_COLLECTIONS = Arrays.asList(
            Arrays.asList("A", "T", "G", "C", "G", "A"),
            Arrays.asList("C", "A", "G", "T", "G", "C"),
            Arrays.asList("T", "T", "A", "T", "T", "T"),
            Arrays.asList("A", "G", "A", "C", "G", "G"),
            Arrays.asList("G", "C", "G", "T", "C", "A"),
            Arrays.asList("T", "C", "A", "C", "T", "G"));

    public static final String[] INVALID_MATRIX = {"ATGCGA", "CAGTGC", "TTATTTTTTT", "AGACGG", "GCGTCA", "A"};
    public static final String[] INVALID_MATRIX_NULL = null;
    public static final String[] VALID_ARRAY_TO_VALIDATE = {"ATGCGA"};
    public static final String[] INVALID_ARRAY_TO_VALIDATE = {""};

    public static final String[][] DNA_MATRIX_VALID_CHAR = {{"A", "T", "G", "C", "G", "A"}, {"C", "A", "G", "T", "G", "C"}, {"T", "T", "A", "T", "T", "T"}, {"A", "G", "A", "C", "G", "G"}, {"A", "G", "A", "C", "G", "G"}, {"A", "G", "A", "C", "G", "G"}};
    public static final String[] DNA_VALID_CHAR = {"A", "T", "C", "G"};
    public static final Integer MUTANT_DNA_CANT_SAME_LETTERS = 4;
    public static final Integer MUTANT_DNA_CANT_SEQUENCE = 1;

    public static final String[] MUTANT_ROW_COMBINATION_DNA = {
            "ATGCGA",
            "AAAAGC",
            "TTATTT",
            "AGACGG",
            "GCGTCA",
            "TCACTG"};

    public static final String[][] MUTANT_ROW_COMBINATION_DNA_MATRIX = {
            {"A", "T", "G", "C", "G", "A"},
            {"A", "A", "A", "A", "G", "C"},
            {"T", "T", "T", "T", "T", "T"},
            {"A", "G", "A", "C", "G", "G"},
            {"G", "C", "G", "T", "C", "A"},
            {"T", "C", "A", "C", "T", "G"}};


    public static final List<List<String>> MUTANT_ROW_COMBINATION_DNA_MATRIX_TO_EXPECTED_COLLECTIONS = Arrays.asList(
            Arrays.asList("A", "T", "G", "C", "G", "A"),
            Arrays.asList("A", "A", "A", "A", "G", "C"),
            Arrays.asList("T", "T", "T", "T", "T", "T"),
            Arrays.asList("A", "G", "A", "C", "G", "G"),
            Arrays.asList("G", "C", "G", "T", "C", "A"),
            Arrays.asList("T", "C", "A", "C", "T", "G"));

    public static final String[] MUTANT_COLUMN_DNA = {
            "ATGCCA",
            "CAGTCA",
            "TTATCA",
            "AGACCA",
            "GCGTGA",
            "TCACTG"};

    public static final String[][] MUTANT_COLUMN_DNA_MATRIX = {
            {"A", "T", "G", "C", "C", "A"},
            {"C", "A", "G", "T", "C", "A"},
            {"T", "T", "A", "T", "C", "A"},
            {"A", "G", "A", "C", "C", "A"},
            {"G", "C", "G", "T", "G", "A"},
            {"T", "C", "A", "C", "T", "G"}};


    public static final List<List<String>> MUTANT_COLUMN_DNA_MATRIX_TO_EXPECTED_COLLECTIONS = Arrays.asList(
            Arrays.asList("A", "C", "T", "A", "G", "T"),
            Arrays.asList("T", "A", "T", "G", "C", "C"),
            Arrays.asList("G", "G", "A", "A", "G", "A"),
            Arrays.asList("C", "T", "T", "C", "T", "C"),
            Arrays.asList("C", "C", "C", "C", "G", "T"),
            Arrays.asList("A", "A", "A", "A", "A", "G"));


    public static final String[] MUTANT_OBLIQUE_DNA = {
            "ATGCGA",
            "CAGTGC",
            "TTATTT",
            "AGAAGG",
            "GCGTCA",
            "TCACTG"};
    public static final String[][] MUTANT_OBLIQUE_DNA_MATRIX = {
            {"A", "T", "G", "C", "G", "A"},
            {"C", "A", "G", "T", "A", "C"},
            {"T", "T", "A", "A", "T", "T"},
            {"A", "G", "A", "A", "G", "G"},
            {"G", "C", "G", "T", "C", "A"},
            {"T", "C", "A", "C", "T", "G"}};

    public static final List<List<String>> MUTANT_OBLIQUE_DNA_MATRIX_TO_EXPECTED_COLLECTIONS = Arrays.asList(
            Arrays.asList("A", "A", "A", "A", "C", "G"),
            Arrays.asList("A", "A", "A", "A", "C", "T"));


    public static final String[] DNA_ARRAY_INVALID_CHAR = {
            "ATGCGA",
            "CAGTGC",
            "TTATTT",
            "AGACGG",
            "GCGTCA",
            "TCMC1Q"};
    public static final String[][] DNA_MATRIX_INVALID_CHAR = {
            {"A", "T", "G", "C", "G", "A"},
            {"C", "A", "G", "T", "G", "C"},
            {"T", "T", "A", "T", "T", "T"},
            {"A", "G", "A", "C", "G", "G"},
            {"G", "C", "G", "T", "C", "A"},
            {"T", "C", "M", "C", "1", "Q"}};


}
