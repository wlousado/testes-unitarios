package br.com.professorlow.infra.gateway.spring.data.entity;

import br.com.professorlow.core.domain.Vehicle;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Vehicle")
public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String registrationPlate;
    private String model;
    private String color;

    public VehicleEntity(Vehicle vehicle) {
        this.id = vehicle.id();
        this.registrationPlate = vehicle.registrationPlate();
        this.model = vehicle.model();
        this.color = vehicle.color();
    }
}
