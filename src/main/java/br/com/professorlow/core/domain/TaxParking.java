package br.com.professorlow.core.domain;

import java.math.BigDecimal;

public record TaxParking (
        Long id,
        BigDecimal firstHour,
        BigDecimal aditionalHour,
        BigDecimal fifteenMinutes
)
{
}
