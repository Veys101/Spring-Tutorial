package com.app.tutorial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.app.tutorial.beans.Vehicle;

@Configuration
public class ProjectConfig {
    
    @Bean
    public Vehicle vehicle1() {
        Vehicle veh = new Vehicle();
        veh.setName("Audi");
        return veh;
    }

    @Bean
    public Vehicle vehicle2() {
        Vehicle veh = new Vehicle();
        veh.setName("Honda");
        return veh;
    }

    @Bean
    public Vehicle vehicle3() {
        Vehicle veh = new Vehicle();
        veh.setName("Ferrari");
        return veh;
    }

    @Bean("fordVehicle")
    public Vehicle vehicle4() {
        Vehicle veh = new Vehicle();
        veh.setName("Ford");
        return veh;
    }
}