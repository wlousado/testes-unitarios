package br.com.professorlow.core.exception.parkingspace;

public class ParkingSpaceIsBusyException extends RuntimeException {
    public ParkingSpaceIsBusyException(String msg) {
        super(msg);
    }
}
