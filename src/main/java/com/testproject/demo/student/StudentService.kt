package com.testproject.demo.student

import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.Month

@Service
class StudentService {
    fun getStudents(): List<Student> {
        return listOf(
            Student(1L, "Marian", "email@gmail.com", LocalDate.of(2001, Month.FEBRUARY, 10), 22),
            Student(1L, "John", "email2@gmail.com", LocalDate.of(2000, Month.DECEMBER, 18), 23)
        )
    }
}