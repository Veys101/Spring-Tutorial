package com.app.tutorial.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.tutorial.interfaces.Speakers;
import com.app.tutorial.interfaces.Tyres;
import com.app.tutorial.model.Song;

@Component
public class VehicleService {
    
    @Autowired
    private Speakers speakers;
    private Tyres tyres;

    public String playMusic(boolean vehicleStarted, Song song){
        return speakers.makeSound(song);
    }

    public String moveVehicle(boolean vehicleStarted){
        return tyres.rotate();
    }

    public String applyBrake(boolean vehicleStarted){
        return tyres.stop();
    }

    public Speakers getSpeakers() {
        return speakers;
    }

    public void setSpeakers(Speakers speakers) {
        this.speakers = speakers;
    }

    public Tyres getTyres() {
        return tyres;
    }

    @Autowired
    public void setTyres(Tyres tyres) {
        this.tyres = tyres;
    }

}
