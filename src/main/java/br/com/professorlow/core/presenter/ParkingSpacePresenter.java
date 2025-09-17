package br.com.professorlow.core.presenter;

import br.com.professorlow.core.domain.ParkingSpace;
import br.com.professorlow.core.dto.parkingspace.ParkingSpaceDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ParkingSpacePresenter {

    public static ParkingSpace toDomain(ParkingSpaceDto dto){
        return new ParkingSpace(dto.code(), dto.status());
    }
}
