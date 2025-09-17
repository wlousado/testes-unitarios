package br.com.professorlow.core.gateway;

import br.com.professorlow.core.domain.ParkingHistory;

import java.util.Optional;

public interface ParkingHistoryGateway {

    Optional<ParkingHistory> searchByRegistrationPlate(String registrationPlate);

    ParkingHistory save(ParkingHistory parkingHistory);

    ParkingHistory searchByCodeParkingHistory(String codeParkingHistory);
}
