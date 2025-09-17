package br.com.professorlow.core.usecase.parkingspace;

import br.com.professorlow.core.domain.ParkingSpace;
import br.com.professorlow.core.exception.parkingspace.ParkingSpaceCodeNotFoundException;
import br.com.professorlow.core.gateway.ParkingSpaceGateway;
import org.springframework.stereotype.Service;

@Service
public class SearchAnParkingSpaceUsecase {

    private final ParkingSpaceGateway parkingSpaceGateway;

    public SearchAnParkingSpaceUsecase(ParkingSpaceGateway parkingSpaceGateway) {
        this.parkingSpaceGateway = parkingSpaceGateway;
    }

    public ParkingSpace getParkingSpace(String code) {
        return parkingSpaceGateway.findBycode(code)
                .orElseThrow(() -> new ParkingSpaceCodeNotFoundException("Parking space " + code + " not found"));
    }
}
