package br.com.professorlow.infra.controller.vehicle;

import br.com.professorlow.core.usecase.vehicle.CreateAnVehicleUsecase;
import br.com.professorlow.core.usecase.vehicle.SearchVehiclesUsecase;
import br.com.professorlow.infra.controller.checkin.request.VehicleRequest;
import br.com.professorlow.infra.controller.vehicle.response.VehicleResponse;
import br.com.professorlow.infra.presenter.VehicleInfraPresenter;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleRestController {

    private final SearchVehiclesUsecase searchVehiclesUsecase;
    private final CreateAnVehicleUsecase createAnVehicleUsecase;

    public VehicleRestController(SearchVehiclesUsecase searchVehiclesUsecase, CreateAnVehicleUsecase createAnVehicleUsecase) {
        this.searchVehiclesUsecase = searchVehiclesUsecase;
        this.createAnVehicleUsecase = createAnVehicleUsecase;
    }

    @GetMapping("/{registrationPlate}")
    public ResponseEntity<VehicleResponse> getVehicle(@PathVariable String registrationPlate){
        var vehicle = searchVehiclesUsecase.getVehicle(registrationPlate);
        return vehicle.map(value -> ResponseEntity.ok(VehicleInfraPresenter.toResponse(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<VehicleResponse> createVehicle(@RequestBody @Valid VehicleRequest vehicleRequest){
        var vehicle = createAnVehicleUsecase.create(VehicleInfraPresenter.toDto(vehicleRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(VehicleInfraPresenter.toResponse(vehicle));
    }

}
