package ru.courier.management.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "chat")
@Getter
@Setter
@NoArgsConstructor
public class Chat {

    @Id
    @UuidGenerator
    private int id;

    private UUID order;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "courier_id", referencedColumnName = "id")
    private Courier courier;

    @OneToMany(mappedBy = "chat")
    private List<Message> messages;

    public Chat(UUID order, Client client, Courier courier) {
        this.order = order;
        this.client = client;
        this.courier = courier;
    }
}
