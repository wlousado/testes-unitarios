package br.com.professorlow.core.usecase.checkout;

import br.com.professorlow.core.domain.ParkingHistory;
import br.com.professorlow.core.gateway.ParkingHistoryGateway;
import br.com.professorlow.core.gateway.ParkingSpaceGateway;
import br.com.professorlow.core.gateway.TaxParkingGateway;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CheckOutUsecase {

    private final ParkingHistoryGateway parkingHistoryGateway;
    private final ParkingSpaceGateway parkingSpaceGateway;
    private final TaxParkingGateway taxParkingGateway;

    public CheckOutUsecase(ParkingHistoryGateway parkingHistoryGateway, ParkingSpaceGateway parkingSpaceGateway, TaxParkingGateway taxParkingGateway) {
        this.parkingHistoryGateway = parkingHistoryGateway;
        this.parkingSpaceGateway = parkingSpaceGateway;
        this.taxParkingGateway = taxParkingGateway;
    }

    public ParkingHistory doCheckout(String codeParkingHistory){
       var pkHistory = parkingHistoryGateway.searchByCodeParkingHistory(codeParkingHistory);
       var result = pkHistory.checkOut(taxParkingGateway.getTaxParking(), LocalDateTime.now());
       parkingSpaceGateway.updateParkingSpace(pkHistory.parkingSpace().doFree());
       return result;
    }
}
