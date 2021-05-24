package com.mercadolibre.mutants.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.mutants.model.dto.HumanDNARequestDTO;
import com.mercadolibre.mutants.service.HumanDNAValidationService;
import com.mercadolibre.mutants.utils.ConstantsTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MutantScannerController.class)
public class MutantScannerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HumanDNAValidationService humanDNAValidationService;


    @Test
    public void humanScanWhenResponseIsTrue() throws Exception {
        Mockito.when(humanDNAValidationService.isMutant(Mockito.any())).thenReturn(Boolean.TRUE);
        var mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        var ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(new HumanDNARequestDTO(ConstantsTest.MUTANT_ROW_COMBINATION_DNA));
        mockMvc.perform(post("/mutant/").contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void humanScanWhenIdResponseIsFalse() throws Exception {
        Mockito.when(humanDNAValidationService.isMutant(Mockito.any())).thenReturn(Boolean.FALSE);
        var mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        var ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(new HumanDNARequestDTO(ConstantsTest.HUMAN_DNA));
        mockMvc.perform(post("/mutant/").contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isForbidden());
    }


}
