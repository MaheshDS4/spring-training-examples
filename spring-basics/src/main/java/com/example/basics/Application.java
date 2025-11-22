package com.example.basics;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Runs several demos sequentially:
 * 1) Hello World using Spring Boot
 * 2) Setter-based DI
 * 3) Constructor-based DI
 * 4) Autowiring demo
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner run(HelloPrinter helloPrinter,
                          SetterDemo setterDemo,
                          ConstructorDemo constructorDemo,
                          AutowireDemo autowireDemo,
                            Car car) {
        return args -> {
            System.out.println("--- Hello World (Spring Boot) ---");
            helloPrinter.print();

            System.out.println("\n--- Setter-based DI ---");
            setterDemo.printInjectedMessage();

            System.out.println("\n--- Constructor-based DI ---");
            constructorDemo.printInjectedMessage();

            System.out.println("\n--- Autowiring demo ---");
            autowireDemo.show();

            System.out.println("\n--- Autowiring car demo ---");
            car.drive();

        };
    }
}
