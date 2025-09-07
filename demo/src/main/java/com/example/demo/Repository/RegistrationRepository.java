package com.example.demo.Repository;


import com.example.demo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration,Long> {
    List<Registration> findByEvent(Event event);
    List<Registration> findByStudent(Student student);
    long countByEventAndAttended(Event event, boolean attended);
}
