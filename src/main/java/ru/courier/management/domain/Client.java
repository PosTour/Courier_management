package ru.courier.management.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
public class Client {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 11)
    private String phone;

    @OneToMany(mappedBy = "client")
    private List<Chat> chats;

    @OneToMany(mappedBy = "client")
    private List<Feedback> feedbacks;

    public Client(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
