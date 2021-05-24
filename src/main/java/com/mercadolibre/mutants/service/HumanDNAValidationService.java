package com.mercadolibre.mutants.service;

import com.mercadolibre.mutants.model.dto.HumanDNARequestDTO;


public interface HumanDNAValidationService {

    boolean isMutant(HumanDNARequestDTO dna);

    boolean validateIfMutant(String[][] matrix);

}
