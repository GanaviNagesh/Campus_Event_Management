package com.example.demo.Service;

import com.example.demo.Repository.CollegeRepository;
import com.example.demo.model.College;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CollegeService {

    private final CollegeRepository collegeRepository;

    public CollegeService(CollegeRepository collegeRepository) {
        this.collegeRepository = collegeRepository;
    }


    public College addCollege(College college) {
        return collegeRepository.save(college);
    }


    public List<College> getAllColleges() {
        return collegeRepository.findAll();
    }


    public Optional<College> getCollegeById(Long id) {
        return collegeRepository.findById(id);
    }

    public College updateCollege(Long id, College updatedCollege) {
        return collegeRepository.findById(id)
                .map(college -> {
                    college.setName(updatedCollege.getName());
                    college.setLocation(updatedCollege.getLocation());
                    return collegeRepository.save(college);
                })
                .orElseThrow(() -> new RuntimeException("College not found with id: " + id));
    }

    public void deleteCollege(Long id) {
        if (!collegeRepository.existsById(id)) {
            throw new RuntimeException("College not found with id: " + id);
        }
        collegeRepository.deleteById(id);
    }
}
