package io.github.tiagoboldori.eventhub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/events")
public class EventController {
    @GetMapping("/list")
    public String list(){
        return "home/index";
    }

    @GetMapping("/create")
    public String create(){
        return "home/index";
    }
}
