package com.example.studentmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

/**
 * Entité JPA représentant un étudiant.
 * Les noms d'attributs ont été personnalisés (studentId, lastName, firstName, birthDate).
 */
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    private String lastName;

    private String firstName;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    public Student() {
    }

    public Student(String lastName, String firstName, Date birthDate) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Student{studentId=" + studentId + ", lastName='" + lastName + '\''
                + ", firstName='" + firstName + '\'' + ", birthDate=" + birthDate + '}';
    }
}
