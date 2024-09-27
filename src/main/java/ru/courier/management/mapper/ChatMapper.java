package ru.courier.management.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.courier.management.domain.Chat;
import ru.courier.management.dto.ChatDto;
import ru.courier.management.service.ClientService;
import ru.courier.management.service.CourierService;

@Mapper
public interface ChatMapper {

    @Mapping(target = "courier", expression = "java(courierService.findCourierById(chatDto.getCourierId())")
    @Mapping(target = "client", expression = "java(clientService.findClientById(chatDto.getClientId())")
    Chat chatDtoToChat(ChatDto chatDto,
                       @Context CourierService courierService,
                       @Context ClientService clientService);
}
