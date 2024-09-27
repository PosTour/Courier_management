package ru.courier.management.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.courier.management.domain.Courier;
import ru.courier.management.dto.CoordinateDto;
import ru.courier.management.dto.CourierDto;
import ru.courier.management.mapper.CourierMapper;
import ru.courier.management.repository.CourierRepository;

import java.util.UUID;

@Service
public class CourierService {

    private final CourierRepository courierRepository;
    private final CourierMapper courierMapper;

    public CourierService(CourierRepository courierRepository, CourierMapper courierMapper) {
        this.courierRepository = courierRepository;
        this.courierMapper = new CourierMapperImpl();
    }

    public Courier findCourierById(UUID id) {
        var courierOpt = courierRepository.findById(id);

        return courierOpt.orElse(null);
    }

    public void save(CourierDto courierDto) {
        var courier = courierMapper.courierDtoToCourier(courierDto);
        courierRepository.save(courier);
    }

    public void updateCoords(CoordinateDto coordinateDto) {
        var courierOptional = courierRepository.findById(coordinateDto.getId());

        if (courierOptional.isPresent()) {
            var courier = courierOptional.get();
            courier.setLatitude(coordinateDto.getLatitude());
            courier.setLongitude(coordinateDto.getLongitude());

            courierRepository.save(courier);
        }
    }
}
