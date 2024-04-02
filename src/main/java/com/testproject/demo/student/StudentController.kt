package com.testproject.demo.student

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["api/v1/student"])
class StudentController @Autowired constructor(
    private val studentService: StudentService
) {

    @GetMapping
    fun getStudents(): List<Student> = studentService.getStudents()
}