package ru.courier.management.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.courier.management.dto.DestinationTimeDto;
import ru.courier.management.exception.YandexFailedRoutingException;
import ru.courier.management.feature.DestinationTimeCalculator;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/routing")
public class RoutingController {

    private final DestinationTimeCalculator destinationTimeCalculator;

    @GetMapping("destination/time")
    public ResponseEntity<Integer> getDestinationTime(@RequestBody DestinationTimeDto destinationTimeDto) {
        try {
            var destinationTime = destinationTimeCalculator.calculate(destinationTimeDto);
            return destinationTime.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.internalServerError().build());
        } catch (YandexFailedRoutingException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
