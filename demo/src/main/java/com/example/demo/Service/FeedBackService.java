package com.example.demo.Service;

import com.example.demo.Repository.*;
import com.example.demo.model.Event;
import com.example.demo.model.Feedback;
import com.example.demo.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedBackService {
    private final FeedbackRepository feedbackRepository;
    private final StudentRepository studentRepository;
    private final EventRepository eventRepository;

    public FeedBackService(FeedbackRepository feedbackRepository,
                           StudentRepository studentRepository,
                           EventRepository eventRepository) {
        this.feedbackRepository = feedbackRepository;
        this.studentRepository = studentRepository;
        this.eventRepository = eventRepository;
    }

    public Feedback addFeedback(Long id, Long eventId,String comments,int rating )
    {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + eventId));
        Feedback feed=new Feedback();
        feed.setStudent(student);
        feed.setEvent(event);
        feed.setComments(comments);
        feed.setRating(rating);
        return feedbackRepository.save(feed);
    }
    public List<Feedback> getFeedbacksByEvent(Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + eventId));
        return feedbackRepository.findByEvent(event);
    }
    public List<Feedback> getFeedbacksByStudent(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));
        return feedbackRepository.findByStudent(student);
    }
    public double getAverageRatingForEvent(Long eventId) {
        List<Feedback> feedbacks = getFeedbacksByEvent(eventId);
        if (feedbacks.isEmpty()) return 0.0;
        return feedbacks.stream()
                .mapToInt(Feedback::getRating)
                .average()
                .orElse(0.0);
    }

}
