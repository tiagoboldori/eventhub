package io.github.tiagoboldori.eventhub.controller;

import io.github.tiagoboldori.eventhub.entity.Event;
import io.github.tiagoboldori.eventhub.entity.EventSession;
import io.github.tiagoboldori.eventhub.service.EventService;
import io.github.tiagoboldori.eventhub.service.EventSessionService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;


@Controller
@RequestMapping("/participant")
public class ParticipantController {

    private EventService eventService;
    private EventSessionService eventSessionService;

    public ParticipantController(EventService eventService, EventSessionService eventSessionService){
        this.eventService = eventService;
        this.eventSessionService = eventSessionService;
    }

    //  ===========================  PARTICIPAÇÃO EM EVENTOS  ==================================
    @GetMapping("/join/{eventId}/{eventToken}")
    public String joinPage(
            @PathVariable Long eventId,
            @PathVariable String eventToken,
            HttpServletRequest request,
            HttpServletResponse response,
            Model model
    ) {

        Event event = eventService.findById(eventId);
        System.out.println("URL: " + eventToken);
        System.out.println("Banco: " + event.getAccessToken());
        if (!event.getAccessToken().equals(eventToken)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        EventSession eventSession = eventSessionService.getOrCreateSession(
                event,
                request,
                response
        );

        eventSessionService.save(eventSession);

        model.addAttribute("event", event);
        model.addAttribute("eventSession", eventSession);

        return "participant/hub";
    }

}
