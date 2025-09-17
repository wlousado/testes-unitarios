package br.com.professorlow.core.presenter;

import br.com.professorlow.core.domain.Vehicle;
import br.com.professorlow.core.dto.vehicle.VehicleDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VehiclePresenter {

    public static VehicleDto toDto(Vehicle vehicle){
        return new VehicleDto(vehicle.registrationPlate(), vehicle.model(), vehicle.color());
    }

    public static Vehicle toDomain(VehicleDto vehicleDto){
        return new Vehicle(vehicleDto.registrationPlate(), vehicleDto.model(), vehicleDto.color());
    }
}
