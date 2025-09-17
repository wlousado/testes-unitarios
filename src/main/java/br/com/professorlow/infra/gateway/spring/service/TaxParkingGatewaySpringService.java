package br.com.professorlow.infra.gateway.spring.service;

import br.com.professorlow.core.domain.TaxParking;
import br.com.professorlow.core.exception.taxparking.TaxParkingAlreadyExists;
import br.com.professorlow.core.exception.taxparking.TaxParkingNotFoundException;
import br.com.professorlow.core.gateway.TaxParkingGateway;
import br.com.professorlow.infra.gateway.spring.data.repository.TaxParkingRepository;
import br.com.professorlow.infra.presenter.TaxParkingInfraPresenter;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TaxParkingGatewaySpringService implements TaxParkingGateway {

    private final TaxParkingRepository taxParkingRepository;

    public TaxParkingGatewaySpringService(TaxParkingRepository taxParkingRepository) {
        this.taxParkingRepository = taxParkingRepository;
    }

    @Override
    public TaxParking getTaxParking() {
        return taxParkingRepository.findAll()
                .stream()
                .findFirst()
                .map(TaxParkingInfraPresenter::toDomain)
                .orElseThrow(TaxParkingNotFoundException::new);
    }

    @Override
    public TaxParking saveTaxParking(TaxParking taxParking) {
        var entity = TaxParkingInfraPresenter.toEntity(taxParking);
        if(Objects.isNull(taxParking.id())) {
            var entitySave = taxParkingRepository.save(entity);
            return TaxParkingInfraPresenter.toDomain(entitySave);
        } else {
            var entityEdit = taxParkingRepository.findById(taxParking.id());
            if(entityEdit.isEmpty()){
                var entitySave = taxParkingRepository.save(entity);
                return TaxParkingInfraPresenter.toDomain(entitySave);
            } else {
                throw new TaxParkingAlreadyExists("Tax parking already exists");
            }
        }
    }

    @Override
    @Transactional
    public void editTaxParking(TaxParking taxParking) {
        var entity = taxParkingRepository.findById(taxParking.id());
        entity.ifPresent(ent -> {
            ent.setAditionalHour(taxParking.aditionalHour());
            ent.setFifteenMinutes(taxParking.fifteenMinutes());
            ent.setFirstHour(taxParking.firstHour());
        });
    }
}
