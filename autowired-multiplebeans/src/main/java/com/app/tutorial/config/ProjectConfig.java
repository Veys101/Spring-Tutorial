package com.app.tutorial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.app.tutorial.beans.Vehicle;

@Configuration
@ComponentScan(basePackages = "com.app.tutorial.beans")
public class ProjectConfig {

    @Bean
    public Vehicle vehicle1() {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Audi");
        return vehicle;
    }

    @Bean
    public Vehicle vehicle2() {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("BMW");
        return vehicle;
    }

    @Bean
    public Vehicle vehicle3() {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Toyota");
        return vehicle;
    }
    
}
