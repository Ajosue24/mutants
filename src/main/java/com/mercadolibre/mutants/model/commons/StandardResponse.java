package com.mercadolibre.mutants.model.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StandardResponse<T> {
    private String message;
    private String severity;
    private T data;


}

