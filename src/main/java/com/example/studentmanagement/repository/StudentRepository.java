package com.example.studentmanagement.repository;

import com.example.studentmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
@RepositoryRestResource(collectionResourceRel = "etudiants", path = "etudiants")
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByLastName(String lastName);

    // Nombre d'étudiants par année de naissance
    @Query("SELECT YEAR(s.birthDate), COUNT(s) FROM Student s GROUP BY YEAR(s.birthDate)")
    Collection<Object[]> countByBirthYear();
}
