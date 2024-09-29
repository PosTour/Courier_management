package ru.courier.management.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class DestinationTimeDto {

    private UUID courierId;

    private BigDecimal clientLongitude;

    private BigDecimal clientLatitude;
}
