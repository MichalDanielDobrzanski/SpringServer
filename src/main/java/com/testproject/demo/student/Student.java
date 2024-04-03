package com.testproject.demo.student;

import jakarta.persistence.*;

import java.time.LocalDate;

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

    @Column(
            name = "age",
            nullable = false
    )
    private int age;

    public Student(String name, String email, LocalDate localDate, int age) {
        this.name = name;
        this.email = email;
        this.localDate = localDate;
        this.age = age;
    }

}