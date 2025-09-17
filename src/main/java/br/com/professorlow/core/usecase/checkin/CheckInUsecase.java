package br.com.professorlow.core.usecase.checkin;

import br.com.professorlow.core.domain.ParkingHistory;
import br.com.professorlow.core.enums.ParkingStatus;
import br.com.professorlow.core.exception.VehicleNotFoundException;
import br.com.professorlow.core.exception.parkingspace.ParkingSpaceCodeNotFoundException;
import br.com.professorlow.core.exception.parkinghistory.ParkingHistoryVehicleAlreadyParked;
import br.com.professorlow.core.exception.parkingspace.ParkingSpaceIsBusyException;
import br.com.professorlow.core.gateway.ParkingHistoryGateway;
import br.com.professorlow.core.gateway.ParkingSpaceGateway;
import br.com.professorlow.core.gateway.VehicleGateway;
import br.com.professorlow.core.gateway.GenerateParkingCodeGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class CheckInUsecase {

    private final ParkingHistoryGateway parkingHistoryGateway;
    private final ParkingSpaceGateway parkingSpaceGateway;
    private final GenerateParkingCodeGateway generator;
    private final VehicleGateway vehicleGateway;

    public CheckInUsecase(ParkingHistoryGateway parkingHistoryGateway, ParkingSpaceGateway parkingSpaceGateway, GenerateParkingCodeGateway generator, VehicleGateway vehicleGateway) {
        this.parkingHistoryGateway = parkingHistoryGateway;
        this.parkingSpaceGateway = parkingSpaceGateway;
        this.generator = generator;
        this.vehicleGateway = vehicleGateway;
    }

    public ParkingHistory doCheckIn(String code, String registrationPlate){
        var parkingSpace = parkingSpaceGateway.findBycode(code)
                .orElseThrow(() -> new ParkingSpaceCodeNotFoundException("Parking space " + code + " not found"));

        if(ParkingStatus.BUSY.equals(parkingSpace.status()))
            throw new ParkingSpaceIsBusyException("Parking space " + code + " is busy");

        var vehicle = vehicleGateway.findByRegistrationPlate(registrationPlate)
                .orElseThrow(() -> new VehicleNotFoundException("Vehicle "+ registrationPlate +" not found"));

        parkingHistoryGateway.searchByRegistrationPlate(registrationPlate)
                .ifPresent(parking-> {
                    throw new ParkingHistoryVehicleAlreadyParked("Vehicle " + parking.vehicle().registrationPlate() + " already parked");
                });

        parkingSpaceGateway.updateParkingSpace(parkingSpace.doBusy());
        var history = new ParkingHistory(generator.generateCode(code), vehicle, parkingSpace.doBusy(), LocalDateTime.now());
        return parkingHistoryGateway.save(history);
    }
}

