package com.example.demo.model;

import com.example.demo.model.Event;
import com.example.demo.model.Student;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "feedbacks")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    private String comments;
    private int rating;
}
