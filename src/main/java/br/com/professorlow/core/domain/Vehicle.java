package br.com.professorlow.core.domain;

import br.com.professorlow.core.exception.vehicle.RegistrationPlateInvalidFormatException;

import java.util.Objects;

public record Vehicle(Long id,
                      String registrationPlate,
                      String model,
                      String color) {

    public Vehicle(String registrationPlate, String model, String color) {
        this(null, validateRegistrationPlante(registrationPlate), model, color);
    }

    private static String validateRegistrationPlante(String registrationPlate) {
        if (Objects.isNull(registrationPlate))
            throw new RegistrationPlateInvalidFormatException("Registration Plante can't be null");
        var sizePlate = registrationPlate.length();
        if (sizePlate <= 0 || sizePlate > 8)
            throw new RegistrationPlateInvalidFormatException("Registration plate " + registrationPlate + " is invalid size");
        return registrationPlate;
    }
}
