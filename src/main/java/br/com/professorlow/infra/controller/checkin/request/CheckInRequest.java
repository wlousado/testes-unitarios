package br.com.professorlow.infra.controller.checkin.request;

import jakarta.validation.constraints.NotEmpty;

public record CheckInRequest(
        @NotEmpty(message = "Code parking space cannot be empty")
        String codeParkingSpace,
        @NotEmpty(message = "Registration plate cannot be empty")
        String registrationPlate
) {
}
