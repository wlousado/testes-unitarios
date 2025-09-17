package br.com.professorlow.core.exception.taxparking;

public class TaxParkingAlreadyExists extends RuntimeException {
    public TaxParkingAlreadyExists(String msg) {
        super(msg);
    }
}
