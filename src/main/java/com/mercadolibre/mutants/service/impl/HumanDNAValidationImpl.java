package com.mercadolibre.mutants.service.impl;

import com.mercadolibre.mutants.configuration.DNAValidatorProperties;
import com.mercadolibre.mutants.exception.DNAValidationException;
import com.mercadolibre.mutants.model.dto.HumanDNARequestDTO;
import com.mercadolibre.mutants.model.entity.RecordsDNAEntity;
import com.mercadolibre.mutants.repository.service.RecordsDNAService;
import com.mercadolibre.mutants.service.HumanDNAValidationService;
import com.mercadolibre.mutants.utils.BusinessMessages;
import com.mercadolibre.mutants.utils.DNAValidatorUtil;
import com.mercadolibre.mutants.utils.MatrixManagementUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class HumanDNAValidationImpl implements HumanDNAValidationService {

    @Autowired
    private DNAValidatorUtil dnaValidatorUtil;

    @Autowired
    private DNAValidatorProperties dnaValidatorProperties;

    @Autowired
    private RecordsDNAService recordsDNAService;


    @Override
    public boolean isMutant(HumanDNARequestDTO dna) {
        if (!dnaValidatorUtil.validateIfDNAIsValidToCheck(dna.getDna()))
            throw new DNAValidationException(BusinessMessages.DNA_WAS_NOT_VALIDATED.message());
        String[][] matrix;
        matrix = MatrixManagementUtil.parseArrayToMatrix(dna.getDna());
        if (!dnaValidatorUtil.validateIfIsValidDNA(matrix))
            throw new DNAValidationException(BusinessMessages.DNA_HAS_INVALID_CHARACTERS.message());


        Optional<RecordsDNAEntity> recordsDNAEntityOptional = recordsDNAService.findByDna(dna.getDna());
        if (recordsDNAEntityOptional.isPresent()) {
            return recordsDNAEntityOptional.get().isMutant();
        }

        boolean isMutant = validateIfMutant(matrix);
        var recordsDNAEntity = new RecordsDNAEntity(Arrays.toString(dna.getDna()), isMutant);
        recordsDNAService.save(recordsDNAEntity);

        return isMutant;
    }

    @Override
    public boolean validateIfMutant(String[][] matrix) {
        int cantSequence = dnaValidatorProperties.getDnaCantSequence();
        int cantCombinationsFounded = 0;
        cantCombinationsFounded += MatrixManagementUtil.validateAllCombinations(MatrixManagementUtil.getRowsListFromMatrix(matrix), dnaValidatorProperties.getDnaCantSameLetters());
        cantCombinationsFounded += MatrixManagementUtil.validateAllCombinations(MatrixManagementUtil.getColumnsListFromMatrix(matrix), dnaValidatorProperties.getDnaCantSameLetters());
        cantCombinationsFounded += MatrixManagementUtil.validateAllCombinations(MatrixManagementUtil.getAllCombinationOblique(matrix), dnaValidatorProperties.getDnaCantSameLetters());
        return cantCombinationsFounded > cantSequence;
    }


}
