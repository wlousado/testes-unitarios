package br.com.professorlow.infra.controller.checkin;

import br.com.professorlow.core.usecase.checkin.CheckInUsecase;

import br.com.professorlow.infra.controller.checkin.request.CheckInRequest;
import br.com.professorlow.infra.controller.parkinghistory.response.ParkingHistoryResponse;
import br.com.professorlow.infra.presenter.ParkingHistoryInfraPresenter;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/checkin")
public class CheckInRestController {

    private final CheckInUsecase checkInUsecase;

    public CheckInRestController(CheckInUsecase checkInUsecase) {
        this.checkInUsecase = checkInUsecase;
    }

    @PostMapping
    public ResponseEntity<ParkingHistoryResponse> doCheckIn(@RequestBody @Valid CheckInRequest checkInRequest){
        var response = checkInUsecase.doCheckIn(checkInRequest.codeParkingSpace(), checkInRequest.registrationPlate());
        return ResponseEntity.ok(ParkingHistoryInfraPresenter.toResponse(response));
    }
}
