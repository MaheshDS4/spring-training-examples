package com.example.basics;

import org.springframework.stereotype.Component;

@Component
public class SetterDemo {
    private MessageProvider provider;

    // setter injection
    public void setProvider(MessageProvider provider) {
        this.provider = provider;
    }

    public void printInjectedMessage() {
        System.out.println("Message via setter: " + provider.getMessage());
    }
}
