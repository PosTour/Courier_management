package ru.courier.management.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "courier")
@Getter
@Setter
@NoArgsConstructor
public class Message {

    public enum SenderType {
        CLIENT("Клиент"),
        COURIER("Курьер");

        private String label;

        SenderType(String label) {
            this.label = label;
        }

        private static final Map<String, SenderType> LOOKUP_MAP = new HashMap<>();

        static {
            for (SenderType type : values()) {
                LOOKUP_MAP.put(type.label, type);
            }
        }

        public static SenderType getTypeByString(String type) {
            return LOOKUP_MAP.get(type);
        }

        @Override
        public String toString() {
            return label;
        }
    }

    @Id
    @UuidGenerator
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "chat_id", referencedColumnName = "id")
    private Chat chat;

    @Enumerated(EnumType.STRING)
    private SenderType sender;

    @Column(nullable = false, length = 500)
    private String message;

    @Column(name = "received_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date receivedAt;

    public Message(Chat chat, String message, Date receivedAt, SenderType sender) {
        this.chat = chat;
        this.message = message;
        this.receivedAt = receivedAt;
        this.sender = sender;
    }
}
