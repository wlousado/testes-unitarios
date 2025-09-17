package br.com.professorlow.infra.presenter;

import br.com.professorlow.core.domain.ParkingHistory;
import br.com.professorlow.infra.controller.parkinghistory.response.ParkingHistoryResponse;
import br.com.professorlow.infra.gateway.spring.data.entity.ParkingHistoryEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ParkingHistoryInfraPresenter {

    public static ParkingHistory toDomain(ParkingHistoryEntity parkingHistory) {
        return new ParkingHistory(
                parkingHistory.getId(),
                parkingHistory.getCode(),
                VehicleInfraPresenter.toDomain(parkingHistory.getVehicle()),
                ParkingSpaceInfraPresenter.toDomain(parkingHistory.getParkingSpace()),
                parkingHistory.getArrivalTime(),
                parkingHistory.getDepartureTime(),
                parkingHistory.getParkingFee());
    }

    public static ParkingHistoryEntity toEntity(ParkingHistory parkingHistory) {
        return new ParkingHistoryEntity(parkingHistory);
    }

    public static ParkingHistoryResponse toResponse(ParkingHistory response) {
        var vehicle = VehicleInfraPresenter.toResponse(response.vehicle());
        var parkingSpace = ParkingSpaceInfraPresenter.toResponse(response.parkingSpace());
        return new ParkingHistoryResponse(
                response.id(),
                response.code(),
                vehicle,
                parkingSpace,
                response.arrivalTime(),
                response.departureTime(),
                response.parkingFee()
        );
    }
}
