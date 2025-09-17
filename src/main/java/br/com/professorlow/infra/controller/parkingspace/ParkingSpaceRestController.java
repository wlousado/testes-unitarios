package br.com.professorlow.infra.controller.parkingspace;

import br.com.professorlow.core.usecase.parkingspace.CreateAnParkingSpaceUsecase;
import br.com.professorlow.core.usecase.parkingspace.SearchAnParkingSpaceUsecase;
import br.com.professorlow.infra.controller.parkingspace.request.ParkingSpaceRequest;
import br.com.professorlow.infra.controller.parkingspace.response.ParkingSpaceResponse;
import br.com.professorlow.infra.presenter.ParkingSpaceInfraPresenter;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/parking")
public class ParkingSpaceRestController {

    private final CreateAnParkingSpaceUsecase createAnParkingSpaceUsecase;
    private final SearchAnParkingSpaceUsecase searchAnParkingSpaceUsecase;

    public ParkingSpaceRestController(CreateAnParkingSpaceUsecase createAnParkingSpaceUsecase, SearchAnParkingSpaceUsecase searchAnParkingSpaceUsecase) {
        this.createAnParkingSpaceUsecase = createAnParkingSpaceUsecase;
        this.searchAnParkingSpaceUsecase = searchAnParkingSpaceUsecase;
    }

    @PostMapping
    public ResponseEntity<ParkingSpaceResponse> createParkingSpace(@RequestBody @Valid ParkingSpaceRequest parkingSpaceRequest){
        var parkingSpace = createAnParkingSpaceUsecase.create(parkingSpaceRequest.code());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ParkingSpaceInfraPresenter.toResponse(parkingSpace));
    }

    @GetMapping("/{code}")
    public ResponseEntity<ParkingSpaceResponse> getParkingSpace(@PathVariable String code) {
        var parkingSpace = searchAnParkingSpaceUsecase.getParkingSpace(code);
        return ResponseEntity.ok(ParkingSpaceInfraPresenter.toResponse(parkingSpace));
    }
}
