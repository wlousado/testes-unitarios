package br.com.professorlow.infra.gateway.spring.service;

import br.com.professorlow.core.domain.ParkingHistory;
import br.com.professorlow.core.exception.parkinghistory.ParkingHistoryNotFoundException;
import br.com.professorlow.core.gateway.ParkingHistoryGateway;
import br.com.professorlow.infra.gateway.spring.data.repository.ParkingHistoryRepository;
import br.com.professorlow.infra.presenter.ParkingHistoryInfraPresenter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParkingHistoryGatewaySpringService implements ParkingHistoryGateway {

    private final ParkingHistoryRepository parkingHistoryRepository;

    public ParkingHistoryGatewaySpringService(ParkingHistoryRepository parkingHistoryRepository){
        this.parkingHistoryRepository = parkingHistoryRepository;
    }

    @Override
    public Optional<ParkingHistory> searchByRegistrationPlate(String registrationPlate) {
        return parkingHistoryRepository.findByVehicleRegistrationPlate(registrationPlate)
                .map(ParkingHistoryInfraPresenter::toDomain);
    }

    @Override
    public ParkingHistory save(ParkingHistory parkingHistory) {
        var entity = parkingHistoryRepository.save(ParkingHistoryInfraPresenter.toEntity(parkingHistory));
        return ParkingHistoryInfraPresenter.toDomain(entity);
    }

    @Override
    public ParkingHistory searchByCodeParkingHistory(String codeParkingHistory) {
        return parkingHistoryRepository.findByCode(codeParkingHistory)
                .map(ParkingHistoryInfraPresenter::toDomain)
                .orElseThrow(ParkingHistoryNotFoundException::new);
    }
}
