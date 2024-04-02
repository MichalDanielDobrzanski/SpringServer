package com.testproject.demo.student

import jakarta.persistence.*
import java.time.LocalDate

@Entity(name = "Student")
@Table(
    name = "student",
    uniqueConstraints = [
        UniqueConstraint(
            name = "student_email_unique",
            columnNames = ["email"]
        )
    ]
)
data class Student(
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
    val id: Long,

    @Column(
        name = "name",
        nullable = false,
        columnDefinition = "TEXT"
    )
    val name: String,

    @Column(
        name = "email",
        nullable = false,
        columnDefinition = "TEXT",
    )
    val email: String,

    @Column(
        name = "local_date",
        nullable = false
    )
    val localDate: LocalDate,

    @Column(
        name = "age",
        nullable = false
    )
    val age: Int
)