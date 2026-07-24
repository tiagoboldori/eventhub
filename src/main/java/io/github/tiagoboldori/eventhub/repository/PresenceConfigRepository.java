package io.github.tiagoboldori.eventhub.repository;

import io.github.tiagoboldori.eventhub.entity.Event;
import io.github.tiagoboldori.eventhub.entity.PresenceConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PresenceConfigRepository extends JpaRepository<PresenceConfig,Long> {
}
