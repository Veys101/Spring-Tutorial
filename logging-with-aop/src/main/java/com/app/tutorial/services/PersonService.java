package com.app.tutorial.services;

import org.springframework.stereotype.Component;

import com.app.tutorial.interfaces.LogAspect;

@Component
public class PersonService {
    
    private String name;

    @LogAspect
    public String printPerson() {
        return "Person name is: " + this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
