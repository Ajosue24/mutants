package com.mercadolibre.mutants.utils;

public enum BusinessMessages {

    DNA_WAS_NOT_VALIDATED("DNA was not validated "),
    DNA_IS_INVALID("DNA is invalid "),
    DNA_HAS_INVALID_CHARACTERS("DNA has invalid characters"),
    DNA_IS_HUMAN("DNA IS FROM Human"),
    DNA_IS_MUTANTS("DNA IS FROM Mutant, Maybe Magneto will recruit you :)"),
    THIS_IS_STATS("Stats are ");

    private final String message;

    BusinessMessages(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
