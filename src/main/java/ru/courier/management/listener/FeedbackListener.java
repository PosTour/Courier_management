package ru.courier.management.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.courier.management.dto.FeedbackDto;
import ru.courier.management.service.FeedbackService;

@Component
@RequiredArgsConstructor
public class FeedbackListener {

    private final FeedbackService feedbackService;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    @KafkaListener(topics = "${spring.kafka.consumer.topics.feedback}", groupId = "${spring.kafka.consumer.group-id}")
    public void handleFeedbackCreation(String message) {
        FeedbackDto feedbackDto = objectMapper.readValue(message, FeedbackDto.class);
        feedbackService.save(feedbackDto);
    }
}
