package com.example.basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {

    private Engine engine;

    public Car (Engine engine){
        this.engine = engine;
    }

    public void drive() {
        engine.startEngine();
    }

}
