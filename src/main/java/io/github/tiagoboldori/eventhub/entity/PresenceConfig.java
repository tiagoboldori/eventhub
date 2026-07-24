package io.github.tiagoboldori.eventhub.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name="presence_config")
public class PresenceConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="event_module_id")
    private EventModule eventModule;

    private boolean enabled;

    @Column(name="require_name")
    private boolean requireName;

    @Column(name = "require_phone")
    private boolean requirePhone;

    @Column(name = "require_email")
    private boolean requireEmail;

    @Column(name = "allow_guest")
    private boolean allowGuest;

    @Column(name = "allow_multiple_checkins")
    private boolean allowMultipleCheckins;


    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    public PresenceConfig(){

    }


    public Long getId() {
        return id;
    }


    public EventModule getEventModule() {
        return eventModule;
    }

    public void setEventModule(EventModule eventModule) {
        this.eventModule = eventModule;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isRequireName() {
        return requireName;
    }

    public void setRequireName(boolean requireName) {
        this.requireName = requireName;
    }

    public boolean isRequirePhone() {
        return requirePhone;
    }

    public void setRequirePhone(boolean requirePhone) {
        this.requirePhone = requirePhone;
    }

    public boolean isRequireEmail() {
        return requireEmail;
    }

    public void setRequireEmail(boolean requireEmail) {
        this.requireEmail = requireEmail;
    }

    public boolean isAllowGuest() {
        return allowGuest;
    }

    public void setAllowGuest(boolean allowGuest) {
        this.allowGuest = allowGuest;
    }

    public boolean isAllowMultipleCheckins() {
        return allowMultipleCheckins;
    }

    public void setAllowMultipleCheckins(boolean allowMultipleCheckins) {
        this.allowMultipleCheckins = allowMultipleCheckins;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

}
