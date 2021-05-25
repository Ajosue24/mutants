package com.mercadolibre.mutants.controller;

import com.mercadolibre.mutants.model.commons.StandardResponse;
import com.mercadolibre.mutants.model.dto.HumanDNARequestDTO;
import com.mercadolibre.mutants.service.HumanDNAValidationService;
import com.mercadolibre.mutants.utils.BusinessMessages;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mutant")
public class MutantScannerController {

    @Autowired
    private HumanDNAValidationService humanDNAValidationService;

    @ApiOperation(value = "Validate DNA", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({ @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 400, message = "Bad Request") })
    @PostMapping
    public ResponseEntity<StandardResponse<Object>> validateDNA(@RequestBody HumanDNARequestDTO humanDNARequestDTO){
        return humanDNAValidationService.isMutant(humanDNARequestDTO)
                ? new ResponseEntity<>(new StandardResponse<>(BusinessMessages.DNA_IS_MUTANTS.message(), HttpStatus.OK.name(), Boolean.TRUE), HttpStatus.OK)
                : new ResponseEntity<>(new StandardResponse<>(BusinessMessages.DNA_IS_HUMAN.message(), HttpStatus.OK.name(), Boolean.FALSE), HttpStatus.FORBIDDEN);
    }
}
