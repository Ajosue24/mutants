package com.mercadolibre.mutants.controller;

import com.mercadolibre.mutants.model.commons.StandardResponse;
import com.mercadolibre.mutants.model.dto.StatsResponseDTO;
import com.mercadolibre.mutants.service.StatsService;
import com.mercadolibre.mutants.utils.BusinessMessages;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class StatsController {


    @Autowired
    private StatsService statsService;

    @ApiOperation(value = "Get stats", produces = MediaType.APPLICATION_JSON_VALUE, response = StatsResponseDTO.class)
    @ApiResponse(code = 200, message = "OK")
    @GetMapping()
    public ResponseEntity<StandardResponse<StatsResponseDTO>> getStats() {
        return new ResponseEntity<>(new StandardResponse<>(BusinessMessages.THIS_IS_STATS.message(), HttpStatus.OK.name(), statsService.getStats()), HttpStatus.OK);
    }

}
