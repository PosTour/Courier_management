package ru.courier.management.mapper;

import org.mapstruct.Mapper;
import ru.courier.management.domain.Courier;
import ru.courier.management.dto.CourierDto;

@Mapper
public interface CourierMapper {
    Courier courierDtoToCourier(CourierDto courierDto);
}
