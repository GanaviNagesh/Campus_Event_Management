package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Data;
import java.util.*;

@Data
@Entity
@Table(name="Students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    private String email;
    @Column(nullable = false)
    private String phone;

    @ManyToOne
    @JoinColumn(name="college_id")
    private College college;

    @OneToMany(mappedBy = "student")
    private List<Registration> registrations;



}
