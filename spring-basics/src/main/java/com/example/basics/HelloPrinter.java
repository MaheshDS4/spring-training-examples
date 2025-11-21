package com.example.basics;

import org.springframework.stereotype.Component;

@Component
public class HelloPrinter {
    public void print() {
        System.out.println("Hello World from Spring Boot!");
    }
}
