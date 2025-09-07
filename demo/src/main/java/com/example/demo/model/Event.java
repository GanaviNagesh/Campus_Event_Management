package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.*;

@Data
@Entity
@Table(name="events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long eventId;
    @Column(nullable = false)
    private String eventName;
    @Column(nullable = false)
    private String eventLocation;
    @Column(nullable = false)
    private LocalDateTime date;

    @OneToMany(mappedBy = "event")
    private List<Registration> registrations;
}
