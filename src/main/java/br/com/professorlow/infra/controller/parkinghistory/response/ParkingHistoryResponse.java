package br.com.professorlow.infra.controller.parkinghistory.response;

import br.com.professorlow.infra.controller.parkingspace.response.ParkingSpaceResponse;
import br.com.professorlow.infra.controller.vehicle.response.VehicleResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ParkingHistoryResponse(
        Long id,
        String ticket,
        VehicleResponse vehicle,
        ParkingSpaceResponse parkingSpace,
        LocalDateTime arrivalTime,
        LocalDateTime departureTime,
        BigDecimal parkingFee
) {

}
