package br.com.professorlow.core.exception.taxparking;

public class TaxParkingNotFoundException extends RuntimeException {

    public TaxParkingNotFoundException() {
        super("Tax parking not found");
    }

    public TaxParkingNotFoundException(String message) {
        super(message);
    }
}
