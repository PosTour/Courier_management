package ru.courier.management.service;

import org.springframework.stereotype.Service;
import ru.courier.management.dto.MessageDto;
import ru.courier.management.mapper.MessageMapper;
import ru.courier.management.repository.MessageRepository;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final ChatService chatService;
    private final MessageMapper messageMapper;

    public MessageService(MessageRepository messageRepository, MessageMapper messageMapper, ChatService chatService) {
        this.messageRepository = messageRepository;
        this.chatService = chatService;
        this.messageMapper = new MessageMapperImpl();
    }

    public void save(MessageDto messageDto) {
        var message = messageMapper.messageDtoToMessage(messageDto, chatService);
        messageRepository.save(message);
    }
}
