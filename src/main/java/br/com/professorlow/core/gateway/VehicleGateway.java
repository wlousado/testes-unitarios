package br.com.professorlow.core.gateway;

import br.com.professorlow.core.domain.Vehicle;

import java.util.Optional;

public interface VehicleGateway {

    Optional<Vehicle> findByRegistrationPlate(String registrationPlate);

    Vehicle createVehicle(Vehicle vehicle);
}
