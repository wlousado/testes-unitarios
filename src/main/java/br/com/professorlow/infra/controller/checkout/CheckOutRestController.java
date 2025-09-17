package br.com.professorlow.infra.controller.checkout;

import br.com.professorlow.core.usecase.checkout.CheckOutUsecase;
import br.com.professorlow.infra.controller.parkinghistory.response.ParkingHistoryResponse;
import br.com.professorlow.infra.presenter.ParkingHistoryInfraPresenter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/checkout")
public class CheckOutRestController {

    private final CheckOutUsecase checkOutUsecase;

    public CheckOutRestController(CheckOutUsecase checkOutUsecase) {
        this.checkOutUsecase = checkOutUsecase;
    }

    @PostMapping("/{codeParkingHistory}")
    public ResponseEntity<ParkingHistoryResponse> doCheckout(@PathVariable String codeParkingHistory){
        var response = checkOutUsecase.doCheckout(codeParkingHistory);
        return ResponseEntity.ok(ParkingHistoryInfraPresenter.toResponse(response));
    }
}
