package ru.courier.management.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.courier.management.domain.Message;
import ru.courier.management.dto.MessageDto;
import ru.courier.management.service.ChatService;

@Mapper
public interface MessageMapper {

    @Mapping(target = "chat", expression = "java(chatService.findChatById(messageDto.getChatId())")
    @Mapping(target = "sender", expression = "java(Message.SenderType.getTypeByString(messageDto.getSenderType());")
    Message messageDtoToMessage(MessageDto messageDto, @Context ChatService chatService);
}
