package ru.courier.management.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.courier.management.dto.ClientDto;
import ru.courier.management.service.ClientService;

@Component
@RequiredArgsConstructor
public class ClientListener {

    private final ClientService clientService;
    private final ObjectMapper mapper;

    @SneakyThrows
    @KafkaListener(topics = "${spring.kafka.consumer.topics.client}", groupId = "${spring.kafka.consumer.group-id}")
    public void handleClientCreation(String message) {
        ClientDto clientDto = mapper.readValue(message, ClientDto.class);
        clientService.save(clientDto);
    }
}
