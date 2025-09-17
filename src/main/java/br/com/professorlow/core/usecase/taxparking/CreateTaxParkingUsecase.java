package br.com.professorlow.core.usecase.taxparking;

import br.com.professorlow.core.domain.TaxParking;
import br.com.professorlow.core.gateway.TaxParkingGateway;
import org.springframework.stereotype.Service;

@Service
public class CreateTaxParkingUsecase {

    private final TaxParkingGateway taxParkingGateway;

    public CreateTaxParkingUsecase(TaxParkingGateway taxParkingGateway) {
        this.taxParkingGateway = taxParkingGateway;
    }

    public TaxParking create(TaxParking taxParking){
        return taxParkingGateway.saveTaxParking(taxParking);
    }
}
