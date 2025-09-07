package com.example.demo.Service;

import com.example.demo.Repository.StudentRepository;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class StudentService {
    @Autowired
    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public Student addStudent(Student student)
    {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents()
    {
        return  studentRepository.findAll();
    }
    public Optional<Student> getStudentById(Long id)
    {
        return studentRepository.findById(id);
    }

    public Student updateStudent(Long id,Student updatedStudent)
    {
        return studentRepository.findById(id).map(
                student -> {
                    student.setName(updatedStudent.getName());
                    student.setEmail(updatedStudent.getEmail());
                    student.setPhone(updatedStudent.getPhone());
                    student.setCollege(updatedStudent.getCollege());
                    return studentRepository.save(student);
                }
        ).orElseThrow(()->new RuntimeException("There is no student with the id: "+id));
    }
    public void deleteStudent(Long id)
    {
        if(!studentRepository.existsById(id))
        {
            throw new RuntimeException("There is no student with the id: "+id);
        }
        studentRepository.deleteById(id);
    }
}
