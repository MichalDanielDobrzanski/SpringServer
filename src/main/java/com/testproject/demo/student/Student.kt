package com.testproject.demo.student

import jakarta.persistence.*
import java.time.LocalDate

@Entity(name = "Student")
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
    val id: Long,
    val name: String,
    val email: String,
    val localDate: LocalDate,
    val age: Int
)