package com.app.tutorial.beans;

public class Vehicle {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void printHello() {
        System.out.println("Printing Hello from Component Vehicle Bean");
    }

}
