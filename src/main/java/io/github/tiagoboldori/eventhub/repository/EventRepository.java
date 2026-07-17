package io.github.tiagoboldori.eventhub.repository;

import io.github.tiagoboldori.eventhub.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {
}
