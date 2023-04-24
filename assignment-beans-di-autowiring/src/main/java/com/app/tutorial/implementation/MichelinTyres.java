package com.app.tutorial.implementation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.app.tutorial.interfaces.Tyres;

@Component
@Primary
public class MichelinTyres implements Tyres {

    @Override
    public void rotate() {
        System.out.println("Michelin Tyres rotated");
    }
    
}
