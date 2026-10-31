package com.example.studentmanagement.service;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public boolean delete(Long studentId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (studentOptional.isPresent()) {
            studentRepository.delete(studentOptional.get());
            return true;
        }
        return false;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public long countStudents() {
        return studentRepository.count();
    }

    public Collection<?> countByBirthYear() {
        return studentRepository.countByBirthYear();
    }
}
