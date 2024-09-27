package ru.courier.management.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.courier.management.domain.Feedback;
import ru.courier.management.dto.FeedbackDto;
import ru.courier.management.service.ClientService;
import ru.courier.management.service.CourierService;

@Mapper
public interface FeedbackMapper {

    @Mapping(target = "courier", expression = "java(courierService.findCourierById(feedbackDto.getCourierId())")
    @Mapping(target = "client", expression = "java(clientService.findClientById(feedbackDto.getClientId())")
    Feedback feedbackDtoToFeedback(FeedbackDto feedbackDto,
                                   @Context CourierService courierService,
                                   @Context ClientService clientService);
}
