package com.mercadolibre.mutants.model.commons;

import com.mercadolibre.mutants.utils.BusinessMessages;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StandardResponseTest {


    @Test
    void standardResponseTest() {
        var standardResponse = new StandardResponse<>();
        standardResponse.setMessage(BusinessMessages.DNA_IS_HUMAN.message());
        standardResponse.setSeverity(HttpStatus.OK.name());
        standardResponse.setData(Boolean.TRUE);
        assertNotNull(standardResponse.getData());
        assertNotNull(standardResponse.getMessage());
        assertNotNull(standardResponse.getSeverity());

    }
}
