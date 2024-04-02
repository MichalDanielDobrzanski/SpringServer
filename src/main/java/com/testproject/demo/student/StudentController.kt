package com.testproject.demo.student

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.time.Month

@RestController
@RequestMapping(path = ["api/v1/student"])
class StudentController {

    @GetMapping
    fun getStudents(): List<Student> {
        return listOf(
            Student(1L, "Marian", "email@gmail.com", LocalDate.of(2001, Month.FEBRUARY, 10), 22),
            Student(1L, "John", "email2@gmail.com", LocalDate.of(2000, Month.DECEMBER, 18), 23)
        )
    }
}