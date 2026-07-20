package io.github.tiagoboldori.eventhub.controller;

import io.github.tiagoboldori.eventhub.entity.Event;
import io.github.tiagoboldori.eventhub.entity.User;
import io.github.tiagoboldori.eventhub.repository.EventRepository;
import io.github.tiagoboldori.eventhub.security.CustomUserDetails;
import io.github.tiagoboldori.eventhub.service.EventService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    private final EventService eventService;

    public DashboardController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/")
    public String indexPage( Authentication authentication, Model model){
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        User user = userDetails.getUser();
        List<Event> events = eventService.listOrganizerEvents(user.getId());
        model.addAttribute("loggedUser", user);
        model.addAttribute("events", events);

        return "dashboard/index";
    }

    @GetMapping("")
    public String indexRedirect(){
        return "redirect:/dashboard/";
    }
}
