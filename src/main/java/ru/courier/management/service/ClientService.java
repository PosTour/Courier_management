package ru.courier.management.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.courier.management.domain.Client;
import ru.courier.management.dto.ClientDto;
import ru.courier.management.mapper.ClientMapper;
import ru.courier.management.repository.ClientRepository;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public void save(ClientDto clientDto) {
        var client = clientMapper.clientToClientDto(clientDto);
        clientRepository.save(client);
    }
}
