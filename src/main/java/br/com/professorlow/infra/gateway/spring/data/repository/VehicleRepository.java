package br.com.professorlow.infra.gateway.spring.data.repository;

import br.com.professorlow.infra.gateway.spring.data.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {
    Optional<VehicleEntity> findByRegistrationPlate(String registrationPlate);
}
