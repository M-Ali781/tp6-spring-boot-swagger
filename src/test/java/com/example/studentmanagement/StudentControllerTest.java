package com.example.studentmanagement;

import com.example.studentmanagement.controller.StudentController;
import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @Test
    void testSaveStudent() {
        Student student = new Student();
        student.setStudentId(1L);
        student.setLastName("Mido");

        when(studentService.save(any(Student.class))).thenReturn(student);

        ResponseEntity<Student> response = studentController.save(student);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Mido", response.getBody().getLastName());
    }

    @Test
    void testDeleteStudent() {
        when(studentService.delete(1L)).thenReturn(true);

        ResponseEntity<Void> response = studentController.delete(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    void testFindAllStudents() {
        when(studentService.findAll()).thenReturn(Arrays.asList(new Student(), new Student()));

        ResponseEntity<List<Student>> response = studentController.findAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
    }

    @Test
    void testCountStudents() {
        when(studentService.countStudents()).thenReturn(10L);

        ResponseEntity<Long> response = studentController.countStudent();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(10L, response.getBody());
    }

    @Test
    void testFindByYear() {
        when(studentService.countByBirthYear()).thenReturn(List.of());

        ResponseEntity<Collection<?>> response = studentController.findByYear();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(0, response.getBody().size());
    }
}
