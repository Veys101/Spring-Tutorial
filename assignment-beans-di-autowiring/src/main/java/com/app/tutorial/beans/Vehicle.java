package com.app.tutorial.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.tutorial.services.VehicleService;

@Component
public class Vehicle {
    
    public final VehicleService vehicleService;

    @Autowired
    public Vehicle(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    public VehicleService getVehicleService() {
        return vehicleService;
    }

    public void playMusic() {
        vehicleService.getSpeakers().makeSound();
    }

    public void move() {
        vehicleService.getTyres().rotate();
    }
}
