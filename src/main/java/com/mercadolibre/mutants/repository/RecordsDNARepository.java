package com.mercadolibre.mutants.repository;

import com.mercadolibre.mutants.model.entity.RecordsDNAEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RecordsDNARepository extends CrudRepository<RecordsDNAEntity, Long> {

    long countByIsMutantTrue();

    long countByIsMutantFalse();

    Optional<RecordsDNAEntity> findAllByDna(String dna);

}
