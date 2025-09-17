package br.com.professorlow.infra.presenter;

import br.com.professorlow.core.domain.TaxParking;
import br.com.professorlow.infra.controller.taxparking.request.TaxParkingRequest;
import br.com.professorlow.infra.controller.taxparking.response.TaxParkingResponse;
import br.com.professorlow.infra.gateway.spring.data.entity.TaxParkingEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TaxParkingInfraPresenter {

    public static TaxParking toDomain(TaxParkingEntity taxParkingEntity) {
        return new TaxParking(taxParkingEntity.getId(),
                taxParkingEntity.getFirstHour(),
                taxParkingEntity.getAditionalHour(),
                taxParkingEntity.getFifteenMinutes());
    }

    public static TaxParkingEntity toEntity(TaxParking taxParking) {
        return new TaxParkingEntity(taxParking);
    }

    public static TaxParkingResponse toResponse(TaxParking taxParking) {
        return new TaxParkingResponse(taxParking);
    }

    public static TaxParking toDomain(TaxParkingRequest request) {
        return new TaxParking(null, request.firstHour(), request.aditionalHour(), request.fifteenMinutes());
    }
}
