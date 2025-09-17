package br.com.professorlow.core.gateway;

import br.com.professorlow.core.domain.TaxParking;

public interface TaxParkingGateway {

    TaxParking getTaxParking();

    TaxParking saveTaxParking(TaxParking taxParking);

    void editTaxParking(TaxParking taxParking);
}
