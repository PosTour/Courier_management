package ru.courier.management.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "yandexRoutingClient", url = "${url.yandex}")
public interface YandexRoutingClient {

    @GetMapping()
    Map<String, Object> getRoute(
            @RequestParam("origins") String origin,
            @RequestParam("destinations") String destination,
            @RequestParam("apikey") String apiKey);
}
