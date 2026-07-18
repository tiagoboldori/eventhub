package io.github.tiagoboldori.eventhub.dto.request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class RegisterEventRequest {

    @NotBlank(message="O nome é obrigatório.")
    private String name;

    @NotBlank(message = "A descrição é obrigatória.")
    @Size(min=10, max=510, message="A descrição deve possuir pelo menos 10 caracteres e no máximo 510.")
    private String description;


    private Long organizerId;


    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime startDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime endDate;


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

    public Long getOrganizerId(){
        return this.organizerId;
    }
    public void setOrganizerId(Long organizerId){
        this.organizerId = organizerId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
