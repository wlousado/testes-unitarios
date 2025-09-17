package br.com.professorlow.infra.presenter;

import br.com.professorlow.core.domain.Vehicle;
import br.com.professorlow.core.dto.vehicle.VehicleDto;
import br.com.professorlow.infra.controller.checkin.request.VehicleRequest;
import br.com.professorlow.infra.controller.vehicle.response.VehicleResponse;
import br.com.professorlow.infra.gateway.spring.data.entity.VehicleEntity;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class VehicleInfraPresenter {

    public static Vehicle toDomain(VehicleEntity vehicle){
        return new Vehicle(vehicle.getId(), vehicle.getRegistrationPlate(), vehicle.getModel(), vehicle.getColor());
    }

    public static VehicleResponse toResponse(Vehicle vehicle){
        return new VehicleResponse(vehicle.id(), vehicle.registrationPlate(), vehicle.model(), vehicle.color());
    }

    public static VehicleEntity toEntity(Vehicle vehicle) {
        return new VehicleEntity(vehicle);
    }

    public static VehicleDto toDto(VehicleRequest vehicleRequest) {
        return new VehicleDto(vehicleRequest.registrationPlate(), vehicleRequest.model(), vehicleRequest.color());
    }
}
