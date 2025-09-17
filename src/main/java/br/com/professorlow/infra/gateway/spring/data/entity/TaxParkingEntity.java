package br.com.professorlow.infra.gateway.spring.data.entity;

import br.com.professorlow.core.domain.TaxParking;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TaxParking")
public class TaxParkingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal firstHour;
    private BigDecimal aditionalHour;
    private BigDecimal fifteenMinutes;

    public TaxParkingEntity(TaxParking taxParking) {
        this.fifteenMinutes = taxParking.fifteenMinutes();
        this.aditionalHour = taxParking.aditionalHour();
        this.firstHour = taxParking.firstHour();
    }
}
