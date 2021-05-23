package com.mercadolibre.mutants.repository.service.impl;

import com.mercadolibre.mutants.model.entity.RecordsDNAEntity;
import com.mercadolibre.mutants.repository.RecordsDNARepository;
import com.mercadolibre.mutants.repository.service.RecordsDNAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Optional;

@Service
@Transactional
public class RecordsDNAServiceImpl implements RecordsDNAService {

    @Autowired
    private RecordsDNARepository recordsDNARepository;


    @Override
    public void save(RecordsDNAEntity recordsDNAEntity) {
        recordsDNARepository.save(recordsDNAEntity);
    }

    @Override
    public long countAllByMutantTrue() {
        return recordsDNARepository.countByIsMutantTrue();
    }

    @Override
    public long countAllByMutantFalse() {
        return recordsDNARepository.countByIsMutantFalse();
    }

    @Override
    public Optional<RecordsDNAEntity> findAllByDNA(String[] dna) {
        return recordsDNARepository.findAllByDna(Arrays.toString(dna));
    }
}
