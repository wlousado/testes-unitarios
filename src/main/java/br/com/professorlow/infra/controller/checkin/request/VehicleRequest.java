package br.com.professorlow.infra.controller.checkin.request;

import jakarta.validation.constraints.NotEmpty;

public record VehicleRequest(
        @NotEmpty(message = "Registration plate cannot be empty")
        String registrationPlate,
        @NotEmpty(message = "Model cannot be empty")
        String model,
        @NotEmpty(message = "Color cannot be empty")
        String color
) {
}
