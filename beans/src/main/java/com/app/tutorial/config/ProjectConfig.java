package com.app.tutorial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.app.tutorial.beans.Vehicle;

@Configuration
public class ProjectConfig {

    @Bean
    public Vehicle vehicle() {
        Vehicle veh = new Vehicle();
        veh.setName("Audi 8");
        return veh;
    }

    @Bean
    public String hello() {
        return "Hello World";
    }

    @Bean
    public Integer number() {
        return 16;
    }
    
}
