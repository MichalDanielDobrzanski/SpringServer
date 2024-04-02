package com.testproject.demo.student

import java.time.LocalDate

data class Student(
    val id: Long,
    val name: String,
    val email: String,
    val localDate: LocalDate,
    val age: Int
)