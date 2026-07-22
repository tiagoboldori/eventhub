package io.github.tiagoboldori.eventhub.controller;

import io.github.tiagoboldori.eventhub.dto.request.RegisterEventRequest;
import io.github.tiagoboldori.eventhub.dto.request.RegisterUserRequest;
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
import java.util.Objects;

@Controller
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;
    private final UserService userService;

    public EventController(EventService eventService, UserService userService) {
        this.eventService = eventService;
        this.userService = userService;
    }



    //  ===========================  LISTAGEM DE EVENTOS (PARA TESTES) ==================================
    @GetMapping("/list_all")
    public String list(Model model){
        model.addAttribute("events", eventService.listAll());
        return "events/list_all";
    }



    //  ===========================  CADASTRO DE EVENTOS ==================================

    @GetMapping("/register")
    public String register(Authentication authentication, Model model){

        model.addAttribute("request", new RegisterEventRequest());

        model.addAttribute("users", userService.listAll());
        return "events/register";
    }

    @PostMapping("/register")
    public String register(Authentication authentication, @Valid @ModelAttribute("request") RegisterEventRequest request, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "events/register";
        }

        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        User user = userDetails.getUser();

        request.setOrganizerId(user.getId());

        eventService.register(request);
        return "redirect:/dashboard";
    }


//  ===========================  EDIÇÃO DE EVENTOS ==================================

    @GetMapping("/{id}/manage")
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
        model.addAttribute("eventId", event.getId());
        return "events/manage";
    }

    @PostMapping("/{id}/manage")
    public String manage(
            @PathVariable Long id,
            Authentication authentication,
            @Valid @ModelAttribute("request") UpdateEventRequest request,
            BindingResult bindingResult,
            Model model
    ){

        if(bindingResult.hasErrors()){
            return "redirect:events/"+id+"/manage";
        }
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        User loggedUser = userDetails.getUser();

        eventService.updateEvent(id, request, loggedUser);

        model.addAttribute("customMessage", "Evento alterado com sucesso!");
        return "redirect:/dashboard";
    }




}
