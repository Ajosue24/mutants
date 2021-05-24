package com.mercadolibre.mutants.model.dto;

import com.mercadolibre.mutants.utils.ConstantsTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HumanDNARequestDTOTest {


    @Test
    void humanDNARequestDTOTestHasCodeAndEquals() {
        var humanDNARequestDTO = new HumanDNARequestDTO(ConstantsTest.MUTANT_COLUMN_DNA);
        assertNotNull(humanDNARequestDTO.getDna());
    }

}
