package io.github.tiagoboldori.eventhub.dto.session;

import io.github.tiagoboldori.eventhub.enums.UserRole;

public class LoggedUser {
    private Long id;

    private String name;

    private String email;

    private UserRole userRole;

    public LoggedUser(Long id, String name, String email, UserRole userRole){
        this.id = id;
        this.email = email;
        this.name = name;
        this.userRole = userRole;
    }
}
