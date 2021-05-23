package com.mercadolibre.mutants.utils;

import com.mercadolibre.mutants.configuration.DNAValidatorProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DNAValidatorUtil {

    @Autowired
    private DNAValidatorProperties dnaValidatorProperties;

    /**
     * validate if dna contains values different to "A", "T", "C", "G"
     *
     * @param dna user-obtained array
     * @return false if is invalid DNA
     */
    public Boolean validateIfIsValidDNA(String[][] dna) {
        List<String> allMatrixElementList = Arrays.stream(dna).flatMap(Arrays::stream).collect(Collectors.toList());
        List<String> validCharList = Arrays.stream(dnaValidatorProperties.getDnaValidChars()).collect(Collectors.toList());
        return allMatrixElementList.stream().noneMatch(obj -> validCharList.stream().noneMatch(obj::contains));
    }

    /**
     * Validate if dna is invalid to check
     * @param dna user-obtained array
     * @return false if is will not checked
     */
    public Boolean validateIfDNAIsValidToCheck(String[] dna) {
        return dna != null && (dnaValidatorProperties.getDnaCantSameLetters() < dna.length  | dnaValidatorProperties.getDnaCantSameLetters() < dna[0].length());
    }

}
