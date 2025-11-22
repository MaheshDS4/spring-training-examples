package com.example.aop;

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
  CommandLineRunner run(DemoService demoService) {
      return args -> {
          System.out.println("--- Calling success method (triggers before, after, around, afterReturning) ---");
          demoService.success("Alice");
          demoService.timeLogs("Time Logs");
      };
  }
}
