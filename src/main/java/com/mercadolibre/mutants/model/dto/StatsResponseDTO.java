package com.mercadolibre.mutants.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatsResponseDTO {
    private Long countMutantsDNA;
    private Long countHumanDNA;
    private Double ratio;
}
