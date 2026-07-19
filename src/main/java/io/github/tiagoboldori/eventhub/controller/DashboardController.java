package io.github.tiagoboldori.eventhub.controller;

import io.github.tiagoboldori.eventhub.entity.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    @GetMapping("/")
    public String index(HttpSession session, Model model){
        User user = (User) session.getAttribute("loggedUser");

        if (user == null){
            return "redirect:/auth/login";
        }

        model.addAttribute("user",user);
        return "dashboard/index";
    }

}
