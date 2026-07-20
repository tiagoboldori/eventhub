package io.github.tiagoboldori.eventhub.controller;

import io.github.tiagoboldori.eventhub.dto.request.RegisterEventRequest;
import io.github.tiagoboldori.eventhub.entity.Event;
import io.github.tiagoboldori.eventhub.repository.EventRepository;
import io.github.tiagoboldori.eventhub.service.EventService;
import io.github.tiagoboldori.eventhub.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;
    private final UserService userService;

    public EventController(EventService eventService, UserService userService) {
        this.eventService = eventService;
        this.userService = userService;
    }

    @GetMapping("/list_all")
    public String list(Model model){
        model.addAttribute("events", eventService.listAll());
        return "event/list_all";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("request", new RegisterEventRequest());
        model.addAttribute("users", userService.listAll());
        return "event/register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("request") RegisterEventRequest request, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "event/register";
        }

        eventService.register(request);
        return "redirect:/event/list_all";
    }
}
