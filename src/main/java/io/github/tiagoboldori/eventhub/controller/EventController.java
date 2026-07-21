package io.github.tiagoboldori.eventhub.controller;

import io.github.tiagoboldori.eventhub.dto.request.RegisterEventRequest;
import io.github.tiagoboldori.eventhub.dto.request.UpdateEventRequest;
import io.github.tiagoboldori.eventhub.entity.Event;
import io.github.tiagoboldori.eventhub.entity.User;
import io.github.tiagoboldori.eventhub.repository.EventRepository;
import io.github.tiagoboldori.eventhub.security.CustomUserDetails;
import io.github.tiagoboldori.eventhub.service.EventService;
import io.github.tiagoboldori.eventhub.service.UserService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return "events/list_all";
    }

    @GetMapping("/register")
    public String register(Authentication authentication, Model model){
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        User user = userDetails.getUser();
        model.addAttribute("loggedUser", user);



        model.addAttribute("request", new RegisterEventRequest());

        model.addAttribute("users", userService.listAll());
        return "events/register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("request") RegisterEventRequest request, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "events/register";
        }

        eventService.register(request);
        return "redirect:/events/list_all";
    }



    @GetMapping("/{id}")
    public String eventPage(
            @PathVariable Long id,
            Authentication authentication,
            Model model
    ){
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        User user = userDetails.getUser();

        Event event = eventService.findOrganizerEvent(id, user);

        UpdateEventRequest request = new UpdateEventRequest();
        request.setName(event.getName());
        request.setDescription(event.getDescription());
        request.setStartDate(event.getStartDate());
        request.setEndDate(event.getEndDate());

        model.addAttribute("request", request);
        model.addAttribute("loggedUser", user);
        model.addAttribute("eventId", event.getId());
        return "events/manage";
    }

    @PostMapping("/{id}")
    public String manage(
            @PathVariable Long id
    ){
        return "redirect:/dashboard";
    }
}
