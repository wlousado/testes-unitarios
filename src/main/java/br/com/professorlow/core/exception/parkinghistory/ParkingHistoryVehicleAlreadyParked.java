package br.com.professorlow.core.exception.parkinghistory;

public class ParkingHistoryVehicleAlreadyParked extends RuntimeException {
    public ParkingHistoryVehicleAlreadyParked(String msg) {
        super(msg);
    }
}
