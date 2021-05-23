package com.mercadolibre.mutants.controller;

import com.mercadolibre.mutants.model.commons.StandardResponse;
import com.mercadolibre.mutants.service.StatsService;
import com.mercadolibre.mutants.utils.BusinessMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mutant")
public class StatsController {


    @Autowired
    private StatsService statsService;

    @GetMapping()
    public ResponseEntity<?> getStats() {
        return new ResponseEntity<>(new StandardResponse(BusinessMessages.THIS_IS_STATS.message(), HttpStatus.OK.name(), statsService.getStats()), HttpStatus.OK);
    }

}
