package io.github.tiagoboldori.eventhub.dto.request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class RegisterEventRequest {

    @NotBlank
    private String name;

    @NotBlank
    @Size(min=10)
    private String description;

    public RegisterEventRequest(){

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
