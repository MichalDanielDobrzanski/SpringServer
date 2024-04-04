package com.testproject.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    List<Student> getStudents() {
        System.out.println("Serving students...");
        return studentRepository.findAll();
    }


    public void addStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()) {
            throw new IllegalStateException("Email " + student.getEmail() + " is taken.");
        }
        System.out.println("Adding student: " + student);
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("Student with id: " + studentId + " does not exist");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Optional<Student> result = studentRepository.findById(studentId);
        if (result.isEmpty()) {
            throw new IllegalStateException("Student with id: " + studentId + " does not exist");
        }
        final Student student = result.get();
        if (name != null && name.length() > 0 && !Objects.equals(name, student.getName())) {
            System.out.println("Updated with name");
            student.setName(name);
        }
        if (email != null && email.length() > 0 && !Objects.equals(email, student.getEmail())) {
            System.out.println("Updated with email");
            var studentResult = studentRepository.findStudentByEmail(email);
            if (studentResult.isPresent()) {
                throw new IllegalStateException("Email " + email + " is already taken.");
            }
            student.setEmail(email);
        }

        studentRepository.save(student);
    }
}