package ru.courier.management.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.courier.management.domain.Client;
import ru.courier.management.dto.ClientDto;
import ru.courier.management.mapper.ClientMapper;
import ru.courier.management.repository.ClientRepository;

import java.util.UUID;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = new ClientMapperImpl();
    }

    public Client findClientById(UUID id) {
        var clientOpt = clientRepository.findById(id);

        return clientOpt.orElse(null);
    }

    public void save(ClientDto clientDto) {
        var client = clientMapper.clientDtoToClient(clientDto);
        clientRepository.save(client);
    }
}
