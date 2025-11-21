package com.example.basics;

import org.springframework.stereotype.Component;

@Component
public class MessageProvider {
    public String getMessage() {
        return "This message is provided by MessageProvider bean.";
    }
}
