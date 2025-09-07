package com.example.demo.Service;

import com.example.demo.Repository.RegistrationRepository;
import com.example.demo.model.Event;
import com.example.demo.model.Registration;
import com.example.demo.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {
    private final RegistrationRepository registrationRepository;
    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public Registration registerStudent(Student student, Event event) {
        Registration reg = new Registration();
        reg.setStudent(student);
        reg.setEvent(event);
        reg.setAttended(false);
        return registrationRepository.save(reg);
    }
    public List<Registration> getRegistationsByEvent(Event event)
    {
        return  registrationRepository.findByEvent(event);
    }
    public List<Registration> getRegistrationsByStudent(Student student) {
        return registrationRepository.findByStudent(student);
    }
    public Registration markAttendance(Long registrationId, boolean attended) {
        Registration reg = registrationRepository.findById(registrationId)
                .orElseThrow(() -> new RuntimeException("Registration not found with id: " + registrationId));
        reg.setAttended(attended);
        return registrationRepository.save(reg);
    }
    public long countAttended(Event event) {
        return registrationRepository.countByEventAndAttended(event, true);
    }

    public long countAbsent(Event event) {
        return registrationRepository.countByEventAndAttended(event, false);
    }

}
