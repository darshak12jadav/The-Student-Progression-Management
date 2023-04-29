package com.example.progression_student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@SpringBootApplication
@EnableWebSecurity
public class TheStudentProgressionManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(TheStudentProgressionManagementApplication.class, args);
        System.out.println("Welcome to The Student Progression Management !! \uD83D\uDE0E \uD83D\uDE0E \uD83D\uDE0E \uD83D\uDE0E ");
    }

}
