package io.github.tiagoboldori.eventhub.controller;

import io.github.tiagoboldori.eventhub.dto.request.RegisterUserRequest;
import io.github.tiagoboldori.eventhub.entity.User;
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
    public String registerPage(Model model){

        model.addAttribute("request", new RegisterUserRequest());

        return "auth/register";
    }
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("request") RegisterUserRequest request, BindingResult bindingResult, Model model){
        if(userService.emailAlreadyExists(request.getEmail())){
            bindingResult.rejectValue(
                    "email",
                    "email.exists",
                    "Já existe um usuário com este e-mail."
            );
        }
        if (bindingResult.hasErrors()){
            return "auth/register";
        }
        userService.register(request);
        return "redirect:/auth/list_all";
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
