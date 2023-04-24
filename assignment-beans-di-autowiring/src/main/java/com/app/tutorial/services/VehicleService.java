package com.app.tutorial.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.app.tutorial.implementation.BoseSpeakers;
import com.app.tutorial.interfaces.Speakers;
import com.app.tutorial.interfaces.Tyres;

@Component
public class VehicleService {

    private Speakers speakers;
    private Tyres tyres;

    @Autowired
    public VehicleService(@Qualifier("boseSpeakers") Speakers speakers, @Qualifier("bridgeStoneTyres") Tyres tyres) {
        this.speakers = speakers;
        this.tyres = tyres;
    }

    public void setSpeakers(Speakers speakers) {
        this.speakers = speakers;
    }

    public Speakers getSpeakers() {
        return speakers;
    }

    public void setTyres(Tyres tyres) {
        this.tyres = tyres;
    }

    public Tyres getTyres() {
        return tyres;
    }
    
}
