package com.mercadolibre.mutants.model.commons;

import com.mercadolibre.mutants.utils.BusinessMessages;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StandardResponseTest {


    @Test
    void standardResponseTest() {
        var standardResponse = new StandardResponse<>(BusinessMessages.DNA_IS_HUMAN.message(),HttpStatus.OK.name(),Boolean.TRUE);
        var mirror = new StandardResponse<>(BusinessMessages.DNA_IS_HUMAN.message(),HttpStatus.OK.name(),Boolean.TRUE);
        assertEquals(standardResponse, mirror);
        assertEquals(standardResponse.hashCode(), mirror.hashCode());
        assertNotNull(standardResponse.getData());
        assertNotNull(standardResponse.getMessage());
        assertNotNull(standardResponse.getSeverity());

    }
}
