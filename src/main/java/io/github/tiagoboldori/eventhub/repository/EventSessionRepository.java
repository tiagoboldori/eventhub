package io.github.tiagoboldori.eventhub.repository;

import io.github.tiagoboldori.eventhub.entity.EventSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventSessionRepository
        extends JpaRepository<EventSession, Long> {

    Optional<EventSession> findByEventIdAndSessionToken(
            Long eventId,
            String deviceHash
    );

}