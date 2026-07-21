package io.github.tiagoboldori.eventhub.controller.advice;

import io.github.tiagoboldori.eventhub.security.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalModelAttributes {

    @ModelAttribute
    public void addLoggedUser(
            Authentication authentication,
            Model model
    ) {

        if (authentication == null) {
            return;
        }

        if (!(authentication.getPrincipal() instanceof CustomUserDetails userDetails)) {
            return;
        }

        model.addAttribute(
                "loggedUser",
                userDetails.getUser()
        );
    }
}