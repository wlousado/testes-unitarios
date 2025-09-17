package br.com.professorlow.core.domain;

import br.com.professorlow.core.enums.ParkingStatus;

public record ParkingSpace(Long id, String code, ParkingStatus status) {

    public ParkingSpace(String code, ParkingStatus status){
        this(null, code, status);
    }

    public ParkingSpace(String code) {
        this(null, code, ParkingStatus.AVAILABLE);
    }

    public ParkingSpace doBusy() {
        return new ParkingSpace(this.id, this.code, ParkingStatus.BUSY);
    }

    public ParkingSpace doFree() {
        return new ParkingSpace(this.id, this.code, ParkingStatus.AVAILABLE);
    }
}
