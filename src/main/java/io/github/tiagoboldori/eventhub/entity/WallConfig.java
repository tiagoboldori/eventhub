package io.github.tiagoboldori.eventhub.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name="wall_config")
public class WallConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="event_module_id")
    private EventModule eventModule;

    private boolean enabled;

    @Column(name="allow_images")
    private boolean allowImages;

    @Column(name="max_message_length")
    private Integer maxMessageLength;


    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    public WallConfig(){

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

    public boolean isAllowImages() {
        return allowImages;
    }

    public void setAllowImages(boolean allowImages) {
        this.allowImages = allowImages;
    }

    public Integer getMaxMessageLength() {
        return maxMessageLength;
    }

    public void setMaxMessageLength(Integer maxMessageLength) {
        this.maxMessageLength = maxMessageLength;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

}
