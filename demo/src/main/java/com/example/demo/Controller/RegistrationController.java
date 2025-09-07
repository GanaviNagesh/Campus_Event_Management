package com.example.demo.Controller;

import com.example.demo.Service.RegistrationService;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.Repository.EventRepository;
import com.example.demo.model.Registration;
import com.example.demo.model.Student;
import com.example.demo.model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registrations")
public class RegistrationController {

    private final RegistrationService registrationService;
    private final StudentRepository studentRepository;
    private final EventRepository eventRepository;

    public RegistrationController(RegistrationService registrationService,
                                  StudentRepository studentRepository,
                                  EventRepository eventRepository) {
        this.registrationService = registrationService;
        this.studentRepository = studentRepository;
        this.eventRepository = eventRepository;
    }

    // ➤ Register a student for an event
    @PostMapping
    public Registration registerStudent(@RequestParam Long studentId,
                                        @RequestParam Long eventId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + eventId));

        return registrationService.registerStudent(student, event);
    }

    // ➤ Get all registrations for a given event
    @GetMapping("/event/{eventId}")
    public List<Registration> getRegistrationsByEvent(@PathVariable Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + eventId));
        return registrationService.getRegistationsByEvent(event);
    }

    // ➤ Get all registrations for a given student
    @GetMapping("/student/{studentId}")
    public List<Registration> getRegistrationsByStudent(@PathVariable Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));
        return registrationService.getRegistrationsByStudent(student);
    }

    // ➤ Mark attendance
    @PatchMapping("/{registrationId}/attendance")
    public Registration markAttendance(@PathVariable Long registrationId,
                                       @RequestParam boolean attended) {
        return registrationService.markAttendance(registrationId, attended);
    }

    // ➤ Count attended students for an event
    @GetMapping("/event/{eventId}/count-attended")
    public long countAttended(@PathVariable Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + eventId));
        return registrationService.countAttended(event);
    }

    // ➤ Count absent students for an event
    @GetMapping("/event/{eventId}/count-absent")
    public long countAbsent(@PathVariable Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + eventId));
        return registrationService.countAbsent(event);
    }
}
