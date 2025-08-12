package edu.miu.cs425.exampractice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExamPracticeApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ExamPracticeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Welcome to SRM WebAPI!");
        System.out.println("Server Started");
    }
}
