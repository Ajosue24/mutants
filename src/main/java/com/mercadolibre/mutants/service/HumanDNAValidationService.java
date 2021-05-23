package com.mercadolibre.mutants.service;

import com.mercadolibre.mutants.model.dto.HumanDNARequestDTO;


public interface HumanDNAValidationService {

    Boolean isMutant(HumanDNARequestDTO dna);
}
