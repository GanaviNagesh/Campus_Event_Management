package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name="colleges")
@Data
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    private String location;

    @OneToMany(mappedBy = "college")
    private List<Student> students;
}
