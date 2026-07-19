package io.github.tiagoboldori.eventhub.dto.request;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
    @NotBlank(message = "Usuário deve informar o email.")
    private String email;

    @NotBlank(message= "Usuário deve informar a senha.")
    private String password;

    public LoginRequest(){}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
