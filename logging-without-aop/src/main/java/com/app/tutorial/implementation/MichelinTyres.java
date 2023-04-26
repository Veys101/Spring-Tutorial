package com.app.tutorial.implementation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.app.tutorial.interfaces.Tyres;

@Component
@Primary
public class MichelinTyres implements Tyres {

    @Override
    public String rotate(){
        return "Vehicle moving with the help of Michelin tyres";
    }

    @Override
    public String stop() {
        return "Vehicle stopped with the help of Michelin tyres";
    }
    
}
