package br.com.professorlow.core.usecase.parkingspace;

import br.com.professorlow.core.domain.ParkingSpace;
import br.com.professorlow.core.gateway.ParkingSpaceGateway;
import org.springframework.stereotype.Service;

@Service
public class CreateAnParkingSpaceUsecase {

    private final ParkingSpaceGateway parkingSpaceGateway;

    public CreateAnParkingSpaceUsecase(ParkingSpaceGateway parkingSpaceGateway) {
        this.parkingSpaceGateway = parkingSpaceGateway;
    }

    public ParkingSpace create(String code) {
        var parking = new ParkingSpace(code);
        return parkingSpaceGateway.findBycode(code)
                .orElse(parkingSpaceGateway.createParkingSpace(parking));
    }
}
