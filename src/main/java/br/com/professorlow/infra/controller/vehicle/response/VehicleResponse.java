package br.com.professorlow.infra.controller.vehicle.response;

public record VehicleResponse(
        Long id,
        String registrationPlate,
        String model,
        String color
) {

    public VehicleResponse(String registrationPlate, String model, String color) {
        this(null, registrationPlate, model, color);
    }
}
