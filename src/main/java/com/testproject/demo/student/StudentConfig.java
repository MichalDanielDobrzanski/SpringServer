package com.testproject.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student entity = new Student("helene", "email@email.com", LocalDate.of(2001, 2, 3));
            Student entity2 = new Student("alex", "alex@email.com", LocalDate.of(2004, 1, 5));

            // hibernate inserts into the db
            System.out.println("Inserted into repository");
            studentRepository.saveAll(List.of(entity, entity2));
        };
    }
}
