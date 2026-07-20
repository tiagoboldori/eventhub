package io.github.tiagoboldori.eventhub.controller;

import io.github.tiagoboldori.eventhub.dto.session.LoggedUser;
import io.github.tiagoboldori.eventhub.entity.User;
import io.github.tiagoboldori.eventhub.security.CustomUserDetails;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    @GetMapping("/")
    public String index( Authentication authentication, Model model){
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        model.addAttribute("loggedUser", userDetails.getUser());
        return "dashboard/index";
    }

}
