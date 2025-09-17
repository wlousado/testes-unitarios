package br.com.professorlow.core.exception;

public class VehicleNotFoundException extends RuntimeException {
    public VehicleNotFoundException(String msg) {
        super(msg);
    }
}
