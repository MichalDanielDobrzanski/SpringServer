package com.testproject.demo.student;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

// @Entity is for Hibernate
@Entity(name = "Student")
@Table(
        name = "student",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "student_email_unique",
                        columnNames = {"email"}
                )
        }
)
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;

    @Column(
            name = "local_date",
            nullable = false
    )
    private LocalDate localDate;

    @Transient
    private int age;

    public Student(Long id, String name, String email, LocalDate localDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.localDate = localDate;
    }

    public Student() {
    }

    public Student(String name, String email, LocalDate localDate) {
        this.name = name;
        this.email = email;
        this.localDate = localDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public int getAge() {
        return Period.between(this.localDate, LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }
}