package com.app.tutorial.beans;

import javax.annotation.PostConstruct;

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

    @PostConstruct
    public void initialize() {
        this.name = "Honda";
    }

    public void printVehicle() {
        System.out.println("Vehicle bean in Spring Context");
    }
}
