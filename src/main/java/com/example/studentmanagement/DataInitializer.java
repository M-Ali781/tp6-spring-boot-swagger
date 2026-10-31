package com.example.studentmanagement;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initStudents(StudentRepository studentRepository) {
        return args -> {
            if (studentRepository.count() > 0) {
                return;
            }
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            studentRepository.saveAll(List.of(
                    new Student("EL AMRANI", "Salma", format.parse("1999-03-14")),
                    new Student("BENNANI", "Youssef", format.parse("1999-11-02")),
                    new Student("CHAKIR", "Nada", format.parse("2001-06-27"))));

            System.out.println("--- Étudiants insérés au démarrage ---");
            studentRepository.findAll().forEach(System.out::println);
        };
    }
}
