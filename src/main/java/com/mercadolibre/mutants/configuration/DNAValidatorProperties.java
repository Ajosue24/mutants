package com.mercadolibre.mutants.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DNAValidatorProperties {


    @Value("${dna-validator.dna-valid-chars}")
    @Getter
    private String[] dnaValidChars;

    @Value("${dna-validator.dna-cant-same-letters}")
    @Getter
    private Integer dnaCantSameLetters;

    @Value("${dna-validator.dna-cant-sequence}")
    @Getter
    private Integer dnaCantSequence;





}
