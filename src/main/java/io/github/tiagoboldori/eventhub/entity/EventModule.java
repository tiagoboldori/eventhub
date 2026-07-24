package io.github.tiagoboldori.eventhub.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="event_modules")
public class EventModule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name="event_id")
    private Event event;


    @ManyToOne
    @JoinColumn(name="module_id")
    private Module module;


    private boolean enabled;


    @Column(name="display_order")
    private Integer displayOrder;


    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;


    public EventModule(){

    }


}
