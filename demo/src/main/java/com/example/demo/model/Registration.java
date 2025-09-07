package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="registrations")
@Data
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long restrationId;

    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name="event_id")
    private Event event;
    private boolean attended;
}
