package br.com.professorlow.infra.controller.taxparking.response;

import br.com.professorlow.core.domain.TaxParking;

import java.math.BigDecimal;

public record TaxParkingResponse(Long id,
                                 BigDecimal firstHour,
                                 BigDecimal aditionalHour,
                                 BigDecimal fifteenMinutes) {

    public TaxParkingResponse(TaxParking taxParking) {
        this(taxParking.id(), taxParking.firstHour(), taxParking.aditionalHour(), taxParking.fifteenMinutes());
    }
}
