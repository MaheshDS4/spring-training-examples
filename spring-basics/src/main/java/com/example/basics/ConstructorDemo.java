package com.example.basics;

import org.springframework.stereotype.Component;

@Component
public class ConstructorDemo {
    private final MessageProvider provider;

    public ConstructorDemo(MessageProvider provider) {
        this.provider = provider;
    }

    public void printInjectedMessage() {
        System.out.println("Message via constructor: " + provider.getMessage());
    }
}
