package ru.courier.management.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "feedback")
@Getter
@Setter
@NoArgsConstructor
public class Feedback {

    @Id
    @UuidGenerator
    private UUID id;

    private UUID order;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "courier_id", referencedColumnName = "id")
    private Courier courier;

    @Min(1)
    @Max(5)
    private int rating;

    @Column(nullable = false, length = 500)
    private String comment;

    public Feedback(UUID order, int rating, Courier courier, Client client, String comment) {
        this.order = order;
        this.rating = rating;
        this.courier = courier;
        this.client = client;
        this.comment = comment;
    }
}
