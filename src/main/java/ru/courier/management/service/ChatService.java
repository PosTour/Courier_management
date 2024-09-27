package ru.courier.management.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.courier.management.domain.Chat;
import ru.courier.management.dto.ChatDto;
import ru.courier.management.mapper.ChatMapper;
import ru.courier.management.repository.ChatRepository;

import java.util.UUID;

@Service
public class ChatService {

    private final ChatRepository chatRepository;
    private final CourierService courierService;
    private final ClientService clientService;
    private final ChatMapper chatMapper;

    public ChatService(ChatRepository chatRepository, CourierService courierService, ClientService clientService) {
        this.chatRepository = chatRepository;
        this.courierService = courierService;
        this.clientService = clientService;
        this.chatMapper = new ChatMapperImpl();
    }

    public Chat findChatById(UUID id) {
        var chatOpt = chatRepository.findById(id);

        return chatOpt.orElse(null);
    }

    public void save(ChatDto chatDto) {
        var chat = chatMapper.chatDtoToChat(chatDto, courierService, clientService);
        chatRepository.save(chat);
    }
}
