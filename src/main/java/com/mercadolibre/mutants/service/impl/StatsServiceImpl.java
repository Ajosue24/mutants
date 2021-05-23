package com.mercadolibre.mutants.service.impl;

import com.mercadolibre.mutants.model.dto.StatsResponseDTO;
import com.mercadolibre.mutants.repository.service.RecordsDNAService;
import com.mercadolibre.mutants.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsServiceImpl implements StatsService {

    @Autowired
    private RecordsDNAService recordsDNAService;

    /**
     * Get stats from BD
     *
     * @return StatsResponseDTO
     */
    @Override
    public StatsResponseDTO getStats() {
        var statsResponseDTO = new StatsResponseDTO();
        statsResponseDTO.setCountMutantsDNA(recordsDNAService.countAllByMutantTrue());
        statsResponseDTO.setCountHumanDNA(recordsDNAService.countAllByMutantFalse());
        if (statsResponseDTO.getCountMutantsDNA() > 0 && statsResponseDTO.getCountHumanDNA() > 0) {
            statsResponseDTO.setRatio((double) statsResponseDTO.getCountMutantsDNA() / statsResponseDTO.getCountHumanDNA());
        }
        return statsResponseDTO;
    }
}
