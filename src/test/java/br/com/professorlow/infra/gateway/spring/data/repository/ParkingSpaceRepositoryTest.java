package br.com.professorlow.infra.gateway.spring.data.repository;

import br.com.professorlow.core.enums.ParkingStatus;
import br.com.professorlow.infra.gateway.spring.data.entity.ParkingSpaceEntity;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class ParkingSpaceRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ParkingSpaceRepository parkingSpaceRepository;

    @Test
    @DisplayName("Should find parking space entity by code successful")
    void case1() {
        //Arrange
        var code = "123";
        var pSpace = new ParkingSpaceEntity(code, ParkingStatus.AVAILABLE);
        createParkingSpace(pSpace);

        //ACT
        var result = parkingSpaceRepository.findByCode(code);

        //ASSERT
        assertTrue(result.isPresent());
        assertEquals(code, result.get().getCode());
    }

    @Test
    @DisplayName("Should not find parking space")
    void case2() {
        //Arrange
        var code = "123";

        //ACT
        var result = parkingSpaceRepository.findByCode(code);

        //ASSERT
        assertTrue(result.isEmpty());
    }

    private void createParkingSpace(ParkingSpaceEntity entity){
        entityManager.persist(entity);
    }
}