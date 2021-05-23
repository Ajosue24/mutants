package com.mercadolibre.mutants.repository.service;

import com.mercadolibre.mutants.model.entity.RecordsDNAEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public interface RecordsDNAService {

    void save(RecordsDNAEntity recordsDNAEntity);

    Optional<RecordsDNAEntity> findAllByDNA(String[] dna);

    long countAllByMutantTrue();

    long countAllByMutantFalse();





}
