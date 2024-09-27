package ru.courier.management.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "courier")
@Getter
@Setter
@NoArgsConstructor
public class Courier {

    @Id
    private UUID id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 11)
    private String phone;

    private BigDecimal longitude;

    private BigDecimal latitude;

    @OneToMany(mappedBy = "courier")
    private List<Chat> chats;

    @OneToMany(mappedBy = "courier")
    private List<Feedback> feedbacks;

    public Courier(UUID id, String name, String phone, BigDecimal longitude, BigDecimal latitude) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}