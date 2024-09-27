package ru.courier.management.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ChatDto {

    private UUID id;

    private UUID order;

    private UUID clientId;

    private UUID courierId;
}
