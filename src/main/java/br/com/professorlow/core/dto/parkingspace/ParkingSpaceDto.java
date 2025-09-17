package br.com.professorlow.core.dto.parkingspace;

import br.com.professorlow.core.enums.ParkingStatus;

public record ParkingSpaceDto(
        String code,
        ParkingStatus status
) {
}
