package io.github.tiagoboldori.eventhub.repository;

import io.github.tiagoboldori.eventhub.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event,Long> {
    List<Event> findByOrganizerIdOrderByStartDateDesc(Long organizerId);

    Optional<Event> findByIdAndOrganizerId(
            Long id,
            Long organizerId
    );
}
