package io.github.tiagoboldori.eventhub.controller;

import io.github.tiagoboldori.eventhub.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    public final UserService userService;

    public AuthController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("/login")
    public String login(){
        return "auth/login";
    }

    @GetMapping("/register")
    public String register(){
        return "auth/register";
    }

    @GetMapping("/logout")
    public String logout(){
        return "auth/logout";
    }

    @GetMapping("/list_all")
    public String listAll(Model model){
        model.addAttribute("users", userService.listAll());
        return "auth/list_all";
    }
}
