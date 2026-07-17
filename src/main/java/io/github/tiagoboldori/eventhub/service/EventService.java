package io.github.tiagoboldori.eventhub.service;

import io.github.tiagoboldori.eventhub.dto.request.RegisterEventRequest;
import io.github.tiagoboldori.eventhub.entity.Event;
import io.github.tiagoboldori.eventhub.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }

    public void register(RegisterEventRequest request){
        Event event = new Event();
        event.setName(request.getName());
        event.setDescription(request.getDescription());

        eventRepository.save(event);
    }

    public List<Event> listAll() { return eventRepository.findAll();}
}
