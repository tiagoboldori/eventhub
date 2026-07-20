package io.github.tiagoboldori.eventhub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/* Anotação @RestController usado para APIs REST (JSON e afins) */
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "redirect:/dashboard";
    }

    @GetMapping("/about")
    public String about() {
        return "home/index";
    }


}