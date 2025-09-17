package br.com.professorlow.core.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public record ParkingHistory(
        Long id,
        String code,
        Vehicle vehicle,
        ParkingSpace parkingSpace,
        LocalDateTime arrivalTime,
        LocalDateTime departureTime,
        BigDecimal parkingFee) {

    private static final BigDecimal MINUTES_IN_HOUR = new BigDecimal("60");
    private static final BigDecimal BLOCK_OF_MINUTES = new BigDecimal("15");

    public ParkingHistory(String code, Vehicle vehicle, ParkingSpace parkingSpace, LocalDateTime arrivalTime) {
        this(null, code, vehicle, parkingSpace, Objects.requireNonNull(arrivalTime, "Arrival time cannot be null"), null, null);
    }

    public ParkingHistory checkOut(TaxParking taxParking, LocalDateTime departureTime) {
        Objects.requireNonNull(departureTime, "Departure time cannot be null");
        if(arrivalTime.isAfter(departureTime))
            throw new IllegalArgumentException("Departure time cannot be before arrival time");
        long timeParking = ChronoUnit.MINUTES.between(arrivalTime, departureTime);
        var fee = calcFee(timeParking, taxParking);
        return new ParkingHistory(this.id, this.code, this.vehicle, this.parkingSpace, this.arrivalTime, departureTime, fee);
    }

    private BigDecimal calcFee(long totalMinutes, TaxParking taxParking) {
        if (totalMinutes <= 0) {
            return BigDecimal.ZERO;
        }

        if (totalMinutes <= MINUTES_IN_HOUR.longValue()) {
            BigDecimal minutes = new BigDecimal(totalMinutes);
            BigDecimal blocks = minutes.divide(BLOCK_OF_MINUTES, 0, RoundingMode.CEILING);
            return taxParking.fifteenMinutes().multiply(blocks);
        }

        BigDecimal fee = taxParking.firstHour();
        long remainingMinutes = totalMinutes - MINUTES_IN_HOUR.longValue();

        BigDecimal remainingMinutesBD = new BigDecimal(remainingMinutes);
        BigDecimal aditionalHours = remainingMinutesBD.divide(MINUTES_IN_HOUR, 0, RoundingMode.FLOOR);
        fee = fee.add(taxParking.aditionalHour().multiply(aditionalHours));

        BigDecimal minutesLeftOver = remainingMinutesBD.remainder(MINUTES_IN_HOUR);
        if (minutesLeftOver.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal blocks = minutesLeftOver.divide(BLOCK_OF_MINUTES, 0, RoundingMode.CEILING);
            fee = fee.add(taxParking.fifteenMinutes().multiply(blocks));
        }
        return fee;
    }
}
