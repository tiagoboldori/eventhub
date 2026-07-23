package io.github.tiagoboldori.eventhub.entity;

import io.github.tiagoboldori.eventhub.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name =  "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;


    private String email;


    private String password;


    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;


    @OneToMany(mappedBy = "organizer")
    private List<Event> events = new ArrayList<>();


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;


    public User(){

    }



    public Long getId(){
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
