package com.testproject.demo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {
    List<Student> getStudents() {
        System.out.println("Serving students...");
        return List.of(
                new Student("Marian", "email@gmail.com", LocalDate.of(2001, Month.FEBRUARY, 10), 22),
                new Student("John", "email2@gmail.com", LocalDate.of(2000, Month.DECEMBER, 18), 23)
        );
    }
}