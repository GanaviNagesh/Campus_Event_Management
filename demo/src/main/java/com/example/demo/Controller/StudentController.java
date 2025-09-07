package com.example.demo.Controller;

import com.example.demo.Service.StudentService;
import com.example.demo.model.Student;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService)
    {
        this.studentService=studentService;
    }
    @PostMapping
    public Student createStudent(@RequestBody Student student)
    {
        return studentService.addStudent(student);
    }
    @GetMapping
    public List<Student> getStudents()
    {
        return  studentService.getAllStudents();
    }
    @GetMapping("/id{id}")
    public Student getStudentById(@PathVariable Long id)
    {
       return  studentService.getStudentById(id).orElseThrow(()->new RuntimeException("There is no Student with the id: "+id));
    }
    @PutMapping("/id{id}")
    public Student updateStudent(@PathVariable Long id,@RequestBody Student updatedStudent)
    {
        return studentService.updateStudent(id,updatedStudent);
    }
    @DeleteMapping("/id{id}")
    public String deleteStudent(@PathVariable Long id)
    {
        studentService.deleteStudent(id);
        return "Student with the id( "+id+" ) is deleted";
    }

}
