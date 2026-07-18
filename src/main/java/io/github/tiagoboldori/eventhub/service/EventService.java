package io.github.tiagoboldori.eventhub.service;

import io.github.tiagoboldori.eventhub.dto.request.RegisterEventRequest;
import io.github.tiagoboldori.eventhub.entity.Event;
import io.github.tiagoboldori.eventhub.entity.User;
import io.github.tiagoboldori.eventhub.repository.EventRepository;
import io.github.tiagoboldori.eventhub.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final UserService userService;

    public EventService(EventRepository eventRepository, UserRepository userRepository, UserService userService){
        this.eventRepository = eventRepository;
        this.userService = userService;
    }

    public void register(RegisterEventRequest request){

        User organizer = userService.findById(request.getOrganizerId());
        Event event = new Event();
        event.setOrganizer(organizer);
        event.setName(request.getName());
        event.setEndDate(request.getEndDate());
        event.setStartDate(request.getStartDate());
        event.setDescription(request.getDescription());

        eventRepository.save(event);
    }

    public List<Event> listAll() { return eventRepository.findAll();}
}
