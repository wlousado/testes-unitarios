package br.com.professorlow.infra.gateway.spring.data.repository;

import br.com.professorlow.infra.gateway.spring.data.entity.ParkingHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParkingHistoryRepository extends JpaRepository<ParkingHistoryEntity, Long> {

    Optional<ParkingHistoryEntity> findByVehicleRegistrationPlate(String registrationPlate);

    Optional<ParkingHistoryEntity> findByCode(String code);
}
