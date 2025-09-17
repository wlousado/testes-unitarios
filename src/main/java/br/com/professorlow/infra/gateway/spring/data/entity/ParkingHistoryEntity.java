package br.com.professorlow.infra.gateway.spring.data.entity;

import br.com.professorlow.core.domain.ParkingHistory;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ParkingHistory")
public class ParkingHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    @OneToOne(cascade = CascadeType.MERGE)
    private VehicleEntity vehicle;
    @OneToOne(cascade = CascadeType.MERGE)
    private ParkingSpaceEntity parkingSpace;
    private LocalDateTime arrivalTime;
    private LocalDateTime departureTime;
    private BigDecimal parkingFee;

    public ParkingHistoryEntity(ParkingHistory parkingHistory) {
        this.code = parkingHistory.code();
        this.vehicle = new VehicleEntity(parkingHistory.vehicle());
        this.parkingSpace = new ParkingSpaceEntity(parkingHistory.parkingSpace());
        this.arrivalTime = parkingHistory.arrivalTime();
        this.departureTime = parkingHistory.departureTime();
        this.parkingFee = parkingHistory.parkingFee();
    }
}
