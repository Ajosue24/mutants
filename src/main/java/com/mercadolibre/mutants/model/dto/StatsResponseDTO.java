package com.mercadolibre.mutants.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StatsResponseDTO {

    private Long countMutantsDNA;
    private Long countHumanDNA;
    private Double ratio;

}
