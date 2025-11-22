package com.example.aop;

import org.springframework.stereotype.Service;

@Service
public class DemoService {
    public String success(String name) throws Exception{
        Thread.sleep(500);
        System.out.println("DemoService.success executing for " + name);
        return "Hello " + name;
    }

    public String timeLogs(String name) throws Exception{
        Thread.sleep(1000);
        System.out.println("DemoService.timeLogs executing for " + name);
        return "Hello " + name;
    }

    public void error() {
        System.out.println("DemoService.error will throw");
        throw new RuntimeException("Simulated exception");
    }
}
