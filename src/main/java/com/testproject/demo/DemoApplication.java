package com.testproject.demo;

import com.testproject.demo.student.Student;
import com.testproject.demo.student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;

@SpringBootApplication
@EnableJpaRepositories(
        basePackages = {"com.testproject.demo.student"}
)
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student entity = new Student("helene", "email@email.com", LocalDate.of(2001, 2, 3), 19);
            // hibernate inserts into the db
            studentRepository.save(entity);
        };
    }
}
