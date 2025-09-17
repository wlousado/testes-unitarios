package br.com.professorlow.infra.controller.taxparking.request;

import java.math.BigDecimal;

public record TaxParkingRequest(
        BigDecimal firstHour,
        BigDecimal aditionalHour,
        BigDecimal fifteenMinutes
) {
}
