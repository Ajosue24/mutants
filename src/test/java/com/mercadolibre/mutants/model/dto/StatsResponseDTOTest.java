package com.mercadolibre.mutants.model.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StatsResponseDTOTest {

    @Test
    void statsResponseDTOTest(){
        var statsResponseDTO = new StatsResponseDTO(40L,100L,.4);
        var mirror = new StatsResponseDTO(40L,100L,.4);
        assertEquals(statsResponseDTO, mirror);
        assertEquals(statsResponseDTO.hashCode(), mirror.hashCode());
        assertNotNull(statsResponseDTO.getCountHumanDNA());
        assertNotNull(statsResponseDTO.getRatio());
        assertNotNull(statsResponseDTO.getCountMutantsDNA());
    }
}
