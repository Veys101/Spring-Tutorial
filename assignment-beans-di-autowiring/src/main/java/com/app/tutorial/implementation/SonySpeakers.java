package com.app.tutorial.implementation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.app.tutorial.interfaces.Speakers;

@Component
@Primary
public class SonySpeakers implements Speakers {

    @Override
    public void makeSound() {
        System.out.println("Sony speakers make sound");
    }
    
}
