package com.app.tutorial.implementation;

import org.springframework.stereotype.Component;

import com.app.tutorial.interfaces.Tyres;

@Component
public class BridgeStoneTyres implements Tyres {

    @Override
    public void rotate() {
        System.out.println("Bridge Stone Tyres rotated");
    }
    
}
