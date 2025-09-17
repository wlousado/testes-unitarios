package br.com.professorlow.infra.gateway.spring.data.repository;

import br.com.professorlow.infra.gateway.spring.data.entity.TaxParkingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxParkingRepository extends JpaRepository<TaxParkingEntity, Long> {

}
