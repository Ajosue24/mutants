package com.mercadolibre.mutants.service.impl;

import com.mercadolibre.mutants.model.dto.StatsResponseDTO;
import com.mercadolibre.mutants.repository.service.RecordsDNAService;
import com.mercadolibre.mutants.service.StatsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class StatsServiceImplTest {

    @Autowired
    private StatsService statsService;

    @MockBean
    private RecordsDNAService recordsDNAService;

    @Test
    void getStats() {
        var statsResponseDTO = new StatsResponseDTO(40L,100L,.4);
        when(recordsDNAService.countAllByMutantTrue()).thenReturn(40L);
        when(recordsDNAService.countAllByMutantFalse()).thenReturn(100L);
        assertEquals(statsResponseDTO,statsService.getStats());

    }
}
