package com.example.demo.Controller;

import com.example.demo.Service.CollegeService;
import com.example.demo.model.College;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colleges")
public class CollegeController {

    private final CollegeService collegeService;

    public CollegeController(CollegeService collegeService) {
        this.collegeService = collegeService;
    }

    @PostMapping
    public College createCollege(@RequestBody College college) {
        return collegeService.addCollege(college);
    }

    @GetMapping
    public List<College> getAllColleges() {
        return collegeService.getAllColleges();
    }

    @GetMapping("/{id}")
    public College getCollegeById(@PathVariable Long id) {
        return collegeService.getCollegeById(id)
                .orElseThrow(() -> new RuntimeException("College not found with id: " + id));
    }

    @PutMapping("/{id}")
    public College updateCollege(@PathVariable Long id, @RequestBody College college) {
        return collegeService.updateCollege(id, college);
    }

    @DeleteMapping("/{id}")
    public String deleteCollege(@PathVariable Long id) {
        collegeService.deleteCollege(id);
        return "College with id " + id + " deleted successfully!";
    }
}
