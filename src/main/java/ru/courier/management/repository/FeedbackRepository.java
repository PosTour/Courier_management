package ru.courier.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.courier.management.domain.Feedback;

import java.util.UUID;

public interface FeedbackRepository extends JpaRepository<Feedback, UUID> {
}
