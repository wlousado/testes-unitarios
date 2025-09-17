package br.com.professorlow.core.usecase.checkin;

import br.com.professorlow.core.domain.ParkingHistory;
import br.com.professorlow.core.domain.ParkingSpace;
import br.com.professorlow.core.domain.Vehicle;
import br.com.professorlow.core.enums.ParkingStatus;
import br.com.professorlow.core.gateway.GenerateParkingCodeGateway;
import br.com.professorlow.core.gateway.ParkingHistoryGateway;
import br.com.professorlow.core.gateway.ParkingSpaceGateway;
import br.com.professorlow.core.gateway.VehicleGateway;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CheckInUsecaseTest {

    @Mock
    private ParkingHistoryGateway parkingHistoryGateway;

    @Mock
    private ParkingSpaceGateway parkingSpaceGateway;

    @Mock
    private GenerateParkingCodeGateway generateParkginCodeGateway;

    @Mock
    private VehicleGateway vehicleGateway;

    @InjectMocks
    private CheckInUsecase checkInUsecase;


    @Test
    @DisplayName("should do check-in successful")
    void doCheckIn() {
        String code = "123";
        String registrationPlate = "ABC-1234";
        var timeArrived = LocalDateTime.now();
        var pSpace = new ParkingSpace(code, ParkingStatus.AVAILABLE);
        var vehicle = new Vehicle(registrationPlate,
                "UNO FIAT",
                "VERMELHO");
        var pHistory = new ParkingHistory(code,
                vehicle,
                pSpace.doBusy(),
                timeArrived);

        //ACT
        when(parkingSpaceGateway.findBycode(code))
                .thenReturn(Optional.of(pSpace));
        when(vehicleGateway.findByRegistrationPlate(registrationPlate))
                .thenReturn(Optional.of(vehicle));
        when(parkingHistoryGateway.save(pHistory))
                .thenReturn(pHistory);
        when(generateParkginCodeGateway.generateCode(code))
                .thenReturn(code);
        var result = checkInUsecase.doCheckIn(code, registrationPlate, timeArrived);

        assertEquals(pHistory.code(), result.code());
        assertEquals(ParkingStatus.BUSY, result.parkingSpace().status());
    }
}