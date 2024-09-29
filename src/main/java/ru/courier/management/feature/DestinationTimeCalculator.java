package ru.courier.management.feature;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import ru.courier.management.api.YandexRoutingClient;
import ru.courier.management.dto.DestinationTimeDto;
import ru.courier.management.exception.*;
import ru.courier.management.service.CourierService;

import java.util.*;

@Component
@RequiredArgsConstructor
public class DestinationTimeCalculator {

    private final CourierService courierService;
    private final YandexRoutingClient routingClient;
    private final Environment environment;

    public Optional<Integer> calculate(DestinationTimeDto dto) throws YandexFailedRoutingException {
        try {
            var routingResponse = requestRouting(dto);
            var rows = (List<Map<String, Object>>) routingResponse.get("rows");
            var row = rows.getFirst();
            var elements = (List<Map<String, Object>>) row.get("elements");
            var element = elements.getFirst();
            var status = (String) element.get("status");
            if (!Objects.equals(status, "OK")) {
                throw new YandexFailedRoutingException();
            }
            var duration = (Map<String, Object>) element.get("duration");
            return Optional.ofNullable((Integer) duration.get("value"));
        } catch (RuntimeException e) {
            return Optional.empty();
        }
    }

    private Map<String, Object> requestRouting(DestinationTimeDto dto) {
        var courier = courierService.findCourierById(dto.getCourierId());
        try {
            return routingClient.getRoute(
                    courier.getLatitude() + "," + courier.getLongitude(),
                    dto.getClientLatitude() + "," + dto.getClientLongitude(),
                    environment.getProperty("apikey"));
        } catch (FeignException e) {
            int statusCode = e.status();
            if (statusCode == 400) {
                throw new YandexMissingPropertiesException();
            } else if (statusCode == 401) {
                throw new YandexApiKeyException();
            } else if (statusCode == 429) {
                throw new YandexCounterLimitException();
            } else {
                throw new YandexInternalServerException();
            }
        }
    }
}
