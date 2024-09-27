package ru.courier.management.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ClientDto {

    private UUID id;

    private String name;

    private String phone;
}
