package ru.courier.management.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.courier.management.dto.MessageDto;
import ru.courier.management.service.MessageService;

@Component
@RequiredArgsConstructor
public class MessageListener {

    private final MessageService messageService;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    @KafkaListener(topics = "${spring.kafka.consumer.topics.message}", groupId = "${spring.kafka.consumer.group-id}")
    public void handleMessageCreation(String message) {
        MessageDto messageDto = objectMapper.readValue(message, MessageDto.class);
        messageService.save(messageDto);
    }
}
