package br.com.professorlow.infra.controller.parkingspace.response;

import br.com.professorlow.core.enums.ParkingStatus;

public record ParkingSpaceResponse(
        String code,
        ParkingStatus status
) {
}
