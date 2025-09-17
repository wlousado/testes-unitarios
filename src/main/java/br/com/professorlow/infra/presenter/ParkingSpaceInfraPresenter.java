package br.com.professorlow.infra.presenter;

import br.com.professorlow.core.domain.ParkingSpace;
import br.com.professorlow.infra.controller.parkingspace.response.ParkingSpaceResponse;
import br.com.professorlow.infra.gateway.spring.data.entity.ParkingSpaceEntity;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class ParkingSpaceInfraPresenter {

    public static ParkingSpace toDomain(ParkingSpaceEntity parkingSpace){
        return new ParkingSpace(parkingSpace.getId(), parkingSpace.getCode(), parkingSpace.getStatus());
    }

    public static ParkingSpaceResponse toResponse(ParkingSpace parkingSpace) {
        return new ParkingSpaceResponse(parkingSpace.code(), parkingSpace.status());
    }

    public static ParkingSpaceEntity toEntity(ParkingSpace parkingSpace) {
        return new ParkingSpaceEntity(parkingSpace);
    }
}
