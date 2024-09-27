package ru.courier.management.mapper;

import org.mapstruct.Mapper;
import ru.courier.management.domain.Client;
import ru.courier.management.dto.ClientDto;

@Mapper
public interface ClientMapper {
    Client clientDtoToClient(ClientDto clientDto);
}
