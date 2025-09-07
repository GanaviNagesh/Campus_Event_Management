package com.example.demo.Controller;
import com.example.demo.Service.FeedBackService;
import com.example.demo.model.Feedback;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {

    private final FeedBackService feedbackService;

    public FeedbackController(FeedBackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping
    public Feedback addFeedback(@RequestParam Long studentId,
                                @RequestParam Long eventId,
                                @RequestParam String comments,
                                @RequestParam int rating) {
        return feedbackService.addFeedback(studentId, eventId, comments, rating);
    }

    @GetMapping("/event/{eventId}")
    public List<Feedback> getFeedbacksForEvent(@PathVariable Long eventId) {
        return feedbackService.getFeedbacksByEvent(eventId);
    }

    @GetMapping("/student/{studentId}")
    public List<Feedback> getFeedbacksByStudent(@PathVariable Long studentId) {
        return feedbackService.getFeedbacksByStudent(studentId);
    }

    @GetMapping("/event/{eventId}/average-rating")
    public double getAverageRatingForEvent(@PathVariable Long eventId) {
        return feedbackService.getAverageRatingForEvent(eventId);
    }
}
