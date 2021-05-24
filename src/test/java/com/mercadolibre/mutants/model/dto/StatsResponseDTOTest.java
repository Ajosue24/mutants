package com.mercadolibre.mutants.model.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StatsResponseDTOTest {

    @Test
    void statsResponseDTOTest(){
        var statsResponseDTO = new StatsResponseDTO(40L,100L,.4);
        assertNotNull(statsResponseDTO.getCountHumanDNA());
        assertNotNull(statsResponseDTO.getRatio());
        assertNotNull(statsResponseDTO.getCountMutantsDNA());
    }
}
