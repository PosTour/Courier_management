package ru.courier.management.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.courier.management.dto.ChatDto;
import ru.courier.management.service.ChatService;

@Component
@RequiredArgsConstructor
public class ChatListener {

    private final ChatService chatService;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    @KafkaListener(topics = "${spring.kafka.consumer.topics.chat}", groupId = "${spring.kafka.consumer.group-id}")
    public void handleChatCreation(String message) {
        ChatDto chatDto = objectMapper.readValue(message, ChatDto.class);
        chatService.save(chatDto);
    }
}
