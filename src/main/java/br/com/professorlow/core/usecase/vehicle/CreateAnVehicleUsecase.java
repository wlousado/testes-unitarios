package br.com.professorlow.core.usecase.vehicle;

import br.com.professorlow.core.domain.Vehicle;
import br.com.professorlow.core.dto.vehicle.VehicleDto;
import br.com.professorlow.core.gateway.VehicleGateway;
import org.springframework.stereotype.Service;

@Service
public class CreateAnVehicleUsecase {

    private final VehicleGateway vehicleGateway;

    public CreateAnVehicleUsecase(VehicleGateway vehicleGateway) {
        this.vehicleGateway = vehicleGateway;
    }

    public Vehicle create(VehicleDto vehicleDto) {
        var vehicle = new Vehicle(vehicleDto.registrationPlate(), vehicleDto.model(), vehicleDto.color());
        return vehicleGateway.createVehicle(vehicle);
    }
}
