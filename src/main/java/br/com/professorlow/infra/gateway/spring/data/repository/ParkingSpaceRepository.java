package br.com.professorlow.infra.gateway.spring.data.repository;

import br.com.professorlow.infra.gateway.spring.data.entity.ParkingSpaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParkingSpaceRepository extends JpaRepository<ParkingSpaceEntity, Long> {

    @Query("SELECT p FROM ParkingSpaceEntity p WHERE p.code = :code")
    Optional<ParkingSpaceEntity> findByCode(String code);
}
