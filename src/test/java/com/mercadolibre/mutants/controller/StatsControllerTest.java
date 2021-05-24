package com.mercadolibre.mutants.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.mutants.model.commons.StandardResponse;
import com.mercadolibre.mutants.model.dto.StatsResponseDTO;
import com.mercadolibre.mutants.service.StatsService;
import com.mercadolibre.mutants.utils.BusinessMessages;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StatsController.class)
class StatsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StatsService statsService;

    @Test
    void DNAScanWhenResponseIsTrue() throws Exception {
        var statsResponseDTO = new StatsResponseDTO(40L, 100L, .4);
        var standardResponseDTO = new StandardResponse<>(BusinessMessages.THIS_IS_STATS.message(), HttpStatus.OK.name(), statsResponseDTO);
        Mockito.when(statsService.getStats()).thenReturn(statsResponseDTO);
        var mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        var ow = mapper.writer().withDefaultPrettyPrinter();
        var response = mockMvc
                .perform(get("/stats").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        assertThat(response).isEqualToIgnoringWhitespace(mapper.writeValueAsString(standardResponseDTO));
    }

}
