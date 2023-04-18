package com.app.tutorial.beans;

import org.springframework.stereotype.Component;

@Component
public class Vehicle {
    
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void printVehicle() {
        System.out.println("Vehicle bean in Spring Context");
    }
}
