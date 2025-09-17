package br.com.professorlow.infra.gateway.spring.service;

import br.com.professorlow.core.domain.Vehicle;
import br.com.professorlow.core.gateway.VehicleGateway;
import br.com.professorlow.infra.gateway.spring.data.repository.VehicleRepository;
import br.com.professorlow.infra.presenter.VehicleInfraPresenter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleGatewaySpringService implements VehicleGateway {

    private final VehicleRepository vehicleRepository;

    public VehicleGatewaySpringService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Optional<Vehicle> findByRegistrationPlate(String registrationPlate) {
        return vehicleRepository.findByRegistrationPlate(registrationPlate)
                .map(VehicleInfraPresenter::toDomain);
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        return VehicleInfraPresenter.toDomain(vehicleRepository.save(VehicleInfraPresenter.toEntity(vehicle)));
    }
}
