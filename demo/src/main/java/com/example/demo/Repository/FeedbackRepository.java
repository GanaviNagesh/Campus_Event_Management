package com.example.demo.Repository;

import com.example.demo.model.Event;
import com.example.demo.model.Feedback;
import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback,Long> {
    List<Feedback> findByEvent(Event event);
    List<Feedback> findByStudent(Student student);
}
