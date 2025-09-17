package br.com.professorlow.infra.controller.parkingspace.request;

import jakarta.validation.constraints.NotEmpty;

public record ParkingSpaceRequest(
        @NotEmpty(message = "Code can't be null")
        String code
) {
}
