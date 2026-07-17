package io.github.tiagoboldori.eventhub.controller;

import io.github.tiagoboldori.eventhub.dto.request.RegisterEventRequest;
import io.github.tiagoboldori.eventhub.entity.Event;
import io.github.tiagoboldori.eventhub.repository.EventRepository;
import io.github.tiagoboldori.eventhub.service.EventService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/event")
public class EventController {
    private final EventService eventService;

    public EventController( EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/list_all")
    public String list(Model model){
        model.addAttribute("events", eventService.listAll());
        return "event/list_all";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("request", new RegisterEventRequest());
        return "event/register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute RegisterEventRequest request, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "event/register";
        }

        eventService.register(request);
        return "redirect:event/list_all";
    }
}
