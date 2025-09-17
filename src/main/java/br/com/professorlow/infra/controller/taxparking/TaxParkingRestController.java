package br.com.professorlow.infra.controller.taxparking;

import br.com.professorlow.core.usecase.taxparking.CreateTaxParkingUsecase;
import br.com.professorlow.infra.controller.taxparking.request.TaxParkingRequest;
import br.com.professorlow.infra.controller.taxparking.response.TaxParkingResponse;
import br.com.professorlow.infra.presenter.TaxParkingInfraPresenter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tax")
public class TaxParkingRestController {

    private final CreateTaxParkingUsecase createTaxParkingUsecase;

    public TaxParkingRestController(CreateTaxParkingUsecase createTaxParkingUsecase) {
        this.createTaxParkingUsecase = createTaxParkingUsecase;
    }

    @PostMapping
    public ResponseEntity<TaxParkingResponse> create(@RequestBody TaxParkingRequest request){
        var taxParking = createTaxParkingUsecase.create(TaxParkingInfraPresenter.toDomain(request));
        return ResponseEntity.ok(TaxParkingInfraPresenter.toResponse(taxParking));
    }
}
