package io.github.tiagoboldori.eventhub.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterUserRequest {
    @NotBlank(message = "Nome é obrigatório.")
    private String name;

    @NotBlank(message = "Email é obrigatório")
    @Email
    private String email;

    @NotBlank(message = "Senha é obrigatória")
    @Size(min=6,max = 11, message = "Senha deve ter ao menos 6 digitos e no máximo 11.")
    private String password;

    public RegisterUserRequest(){

    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }


    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }


    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

}
