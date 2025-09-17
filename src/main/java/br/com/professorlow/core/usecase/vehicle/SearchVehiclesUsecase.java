package br.com.professorlow.core.usecase.vehicle;

import br.com.professorlow.core.domain.Vehicle;
import br.com.professorlow.core.gateway.VehicleGateway;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SearchVehiclesUsecase {

    private final VehicleGateway vehicleGateway;

    public SearchVehiclesUsecase(VehicleGateway vehicleGateway) {
        this.vehicleGateway = vehicleGateway;
    }

    public Optional<Vehicle> getVehicle(String registrationPlate) {
        return vehicleGateway.findByRegistrationPlate(registrationPlate);
    }
}
