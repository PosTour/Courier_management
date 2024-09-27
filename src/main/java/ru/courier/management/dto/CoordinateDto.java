package ru.courier.management.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class CoordinateDto {

    private UUID id;

    private BigDecimal longitude;

    private BigDecimal latitude;
}
