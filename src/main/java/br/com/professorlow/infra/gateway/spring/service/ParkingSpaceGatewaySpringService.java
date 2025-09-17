package br.com.professorlow.infra.gateway.spring.service;

import br.com.professorlow.core.domain.ParkingSpace;
import br.com.professorlow.core.gateway.ParkingSpaceGateway;
import br.com.professorlow.infra.gateway.spring.data.entity.ParkingSpaceEntity;
import br.com.professorlow.infra.gateway.spring.data.repository.ParkingSpaceRepository;
import br.com.professorlow.infra.presenter.ParkingSpaceInfraPresenter;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParkingSpaceGatewaySpringService implements ParkingSpaceGateway {

    private final ParkingSpaceRepository parkingSpaceRepository;

    public ParkingSpaceGatewaySpringService(ParkingSpaceRepository parkingSpaceRepository) {
        this.parkingSpaceRepository = parkingSpaceRepository;
    }

    @Override
    public Optional<ParkingSpace> findBycode(String code) {
        return parkingSpaceRepository.findByCode(code)
                .map(ParkingSpaceInfraPresenter::toDomain);
    }

    @Override
    public ParkingSpace createParkingSpace(ParkingSpace parkingSpace) {
        ParkingSpaceEntity parking = parkingSpaceRepository.save(ParkingSpaceInfraPresenter.toEntity(parkingSpace));
        return ParkingSpaceInfraPresenter.toDomain(parking);
    }

    @Override
    @Transactional
    public void updateParkingSpace(ParkingSpace parkingSpace) {
        var parkingEdit = parkingSpaceRepository.findById(parkingSpace.id());
        parkingEdit.ifPresent(parkingSpaceEntity ->{
                parkingSpaceEntity.setCode(parkingSpace.code());
                parkingSpaceEntity.setStatus(parkingSpace.status());
        });
    }
}
