package ru.courier.management.service;

import org.springframework.stereotype.Service;
import ru.courier.management.dto.FeedbackDto;
import ru.courier.management.mapper.FeedbackMapper;
import ru.courier.management.repository.FeedbackRepository;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final CourierService courierService;
    private final ClientService clientService;
    private final FeedbackMapper feedbackMapper;

    public FeedbackService(FeedbackRepository feedbackRepository, FeedbackMapper feedbackMapper, CourierService courierService, ClientService clientService) {
        this.feedbackRepository = feedbackRepository;
        this.courierService = courierService;
        this.clientService = clientService;
        this.feedbackMapper = new FeedbackMapperImpl();
    }

    public void save(FeedbackDto feedbackDto) {
        var feedback = feedbackMapper.feedbackDtoToFeedback(feedbackDto, courierService, clientService);
        feedbackRepository.save(feedback);
    }
}
