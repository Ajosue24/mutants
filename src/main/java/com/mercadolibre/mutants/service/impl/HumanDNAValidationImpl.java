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

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
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
        if (matrix == null) throw new DNAValidationException(BusinessMessages.DNA_IS_INVALID.message());
        if (!dnaValidatorUtil.validateIfIsValidDNA(matrix))
            throw new DNAValidationException(BusinessMessages.DNA_HAS_INVALID_CHARACTERS.message());


        Optional<RecordsDNAEntity> recordsDNAEntity = recordsDNAService.findAllByDNA(dna.getDna());
        if (recordsDNAEntity.isPresent()) {
            return recordsDNAEntity.get().isMutant();
        }

        int cantSequence = dnaValidatorProperties.getDnaCantSequence();
        if (MatrixManagementUtil.validateAllCombinations(MatrixManagementUtil.getRowsListFromMatrix(matrix), dnaValidatorProperties.getDnaCantSameLetters()) > cantSequence)
            return true;
        if (MatrixManagementUtil.validateAllCombinations(MatrixManagementUtil.getColumnsListFromMatrix(matrix), dnaValidatorProperties.getDnaCantSameLetters()) > cantSequence)
            return true;
        if (MatrixManagementUtil.validateAllCombinations(MatrixManagementUtil.getAllCombinationOblique(matrix), dnaValidatorProperties.getDnaCantSameLetters()) > cantSequence)
            return true;


        return false;
    }

}
