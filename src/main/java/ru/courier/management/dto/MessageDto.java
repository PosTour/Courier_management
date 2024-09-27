package ru.courier.management.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class MessageDto {

    private UUID chatId;

    private String senderType;

    private String message;

    private Date receivedAt;
}
