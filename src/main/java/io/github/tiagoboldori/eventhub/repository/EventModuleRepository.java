package io.github.tiagoboldori.eventhub.repository;

import io.github.tiagoboldori.eventhub.entity.Event;
import io.github.tiagoboldori.eventhub.entity.EventModule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventModuleRepository extends JpaRepository<EventModule,Long> {
//    List<Event> findByOrganizerIdOrderByStartDateDesc(Long organizerId);
//
//    Optional<Event> findByIdAndOrganizerId(
//            Long id,
//            Long organizerId
//    );
}
