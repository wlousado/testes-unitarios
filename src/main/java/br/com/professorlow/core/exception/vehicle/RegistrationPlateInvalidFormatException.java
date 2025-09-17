package br.com.professorlow.core.exception.vehicle;

public class RegistrationPlateInvalidFormatException extends RuntimeException {
    public RegistrationPlateInvalidFormatException(String message) {
        super(message);
    }
}
