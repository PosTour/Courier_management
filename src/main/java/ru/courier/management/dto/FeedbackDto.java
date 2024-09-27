package ru.courier.management.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class FeedbackDto {

    private UUID order;

    private UUID clientId;

    private UUID courierId;

    private int rating;

    private String comment;
}
