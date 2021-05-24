package com.mercadolibre.mutants.model.dto;

import com.mercadolibre.mutants.utils.ConstantsTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HumanDNARequestDTOTest {


    @Test
    void humanDNARequestDTOTestHasCodeAndEquals() {
        var humanDNARequestDTO = new HumanDNARequestDTO(ConstantsTest.MUTANT_COLUMN_DNA);
        var mirror = new HumanDNARequestDTO(ConstantsTest.MUTANT_COLUMN_DNA);
        assertEquals(humanDNARequestDTO, mirror);
        assertEquals(humanDNARequestDTO.hashCode(), mirror.hashCode());
        assertNotNull(humanDNARequestDTO.getDna());
    }

}
