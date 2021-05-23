package com.mercadolibre.mutants.repository.service;

import com.mercadolibre.mutants.model.entity.RecordsDNAEntity;

import java.util.Optional;


public interface RecordsDNAService {

    void save(RecordsDNAEntity recordsDNAEntity);

    Optional<RecordsDNAEntity> findAllByDNA(String[] dna);

    long countAllByMutantTrue();

    long countAllByMutantFalse();


}
