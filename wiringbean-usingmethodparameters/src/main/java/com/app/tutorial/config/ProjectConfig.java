package com.app.tutorial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.app.tutorial.beans.Person;
import com.app.tutorial.beans.Vehicle;

@Configuration
public class ProjectConfig {
   
    @Bean
    public Person person(Vehicle vehicle) {
        Person person = new Person();
        person.setName("John");
        person.setVehicle(vehicle);
        System.out.println("xxx");
        return person;
    }
    
    @Bean
    public Vehicle vehicle() {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Toyota");
        return vehicle;
    }

}
