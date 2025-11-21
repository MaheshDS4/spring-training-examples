package com.example.rest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
  public static void main(String[] args) {
      SpringApplication.run(Application.class, args);
  }

  @Bean
  CommandLineRunner startup() {
      return args -> System.out.println("Spring Boot REST app started on port 8081");
  }
}
