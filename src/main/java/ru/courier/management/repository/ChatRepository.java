package ru.courier.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.courier.management.domain.Chat;

import java.util.UUID;

@Repository
public interface ChatRepository extends JpaRepository<Chat, UUID> {
}
