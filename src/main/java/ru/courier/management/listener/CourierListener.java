package ru.courier.management.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.courier.management.dto.CoordinateDto;
import ru.courier.management.dto.CourierDto;
import ru.courier.management.service.CourierService;

@Component
@RequiredArgsConstructor
public class CourierListener {

    private final CourierService courierService;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    @KafkaListener(topics = "${spring.kafka.consumer.topics.courier}", groupId = "${spring.kafka.consumer.group-id}")
    public void handleCourierCreation(String message) {
        CourierDto courierDto = objectMapper.readValue(message, CourierDto.class);
        courierService.save(courierDto);
    }

    @SneakyThrows
    @KafkaListener(topics = "${spring.kafka.consumer.topics.coords}", groupId = "${spring.kafka.consumer.group-id}")
    public void handleCoordsUpdate(String message) {
        CoordinateDto coordinateDto = objectMapper.readValue(message, CoordinateDto.class);
        courierService.updateCoords(coordinateDto);
    }
}