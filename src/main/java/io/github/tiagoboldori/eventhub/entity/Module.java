package io.github.tiagoboldori.eventhub.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="modules")
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String slug;

    private String description;

    private String icon;

    @Column(name = "default_enabled")
    private boolean defaultEnabled;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    public Module(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Boolean getDefaultEnabled() {
        return defaultEnabled;
    }

    public void setDefaultEnabled(Boolean defaultEnabled) {
        this.defaultEnabled = defaultEnabled;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
