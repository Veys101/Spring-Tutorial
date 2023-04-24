package com.app.tutorial.implementation;

import org.springframework.stereotype.Component;

import com.app.tutorial.interfaces.Speakers;

@Component
public class BoseSpeakers implements Speakers {

    @Override
    public void makeSound() {
        System.out.println("Bose speakers make sound");
    }
    
}
