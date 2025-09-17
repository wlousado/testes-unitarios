package br.com.professorlow.infra.gateway.spring.data.entity;

import br.com.professorlow.core.domain.ParkingSpace;
import br.com.professorlow.core.enums.ParkingStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ParkingSpace")
public class ParkingSpaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private ParkingStatus status;

    public ParkingSpaceEntity(ParkingSpace parkingSpace) {
        this.id = parkingSpace.id();
        this.code = parkingSpace.code();
        this.status = parkingSpace.status();
    }

    public ParkingSpaceEntity(String code, ParkingStatus parkingStatus) {
        this.code = code;
        this.status = parkingStatus;
    }
}
