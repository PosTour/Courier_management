package ru.courier.management.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.courier.management.domain.Courier;
import ru.courier.management.dto.CoordinateDto;
import ru.courier.management.dto.CourierDto;

@Mapper
public interface CourierMapper {
    Courier courierDtoToCourier(CourierDto courierDto);
}
