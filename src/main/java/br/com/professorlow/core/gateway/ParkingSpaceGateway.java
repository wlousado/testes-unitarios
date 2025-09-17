package br.com.professorlow.core.gateway;

import br.com.professorlow.core.domain.ParkingSpace;

import java.util.Optional;

public interface ParkingSpaceGateway {

    Optional<ParkingSpace> findBycode(String code);

    ParkingSpace createParkingSpace(ParkingSpace parkingSpace);

    void updateParkingSpace(ParkingSpace parkingSpace);
}
