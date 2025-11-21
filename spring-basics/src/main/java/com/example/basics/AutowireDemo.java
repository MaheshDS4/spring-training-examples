package com.example.basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutowireDemo {
    @Autowired
    private MessageProvider provider;

    public void show() {
        System.out.println("Autowired message: " + provider.getMessage());
    }
}
