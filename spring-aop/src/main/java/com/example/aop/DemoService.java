package com.example.aop;

import org.springframework.stereotype.Service;

@Service
public class DemoService {
    public String success(String name) {
        System.out.println("DemoService.success executing for " + name);
        return "Hello " + name;
    }

    public void error() {
        System.out.println("DemoService.error will throw");
        throw new RuntimeException("Simulated exception");
    }
}
